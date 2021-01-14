package io.github.fogeid.zupBank.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.fogeid.zupBank.entities.Conta;
import io.github.fogeid.zupBank.exceptions.CpfAlreadyExistsException;
import io.github.fogeid.zupBank.exceptions.EmailAlreadyExistsException;
import io.github.fogeid.zupBank.repositories.ContaRepository;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository repository;
	
	public Conta insert(Conta obj) {
		isNewUser(obj);
		return repository.save(obj);
	}
	
	public Conta findById(Long id) {
		Optional<Conta> obj = repository.findById(id);
		
		return obj.get();
	}
	
	private boolean isNewUser(Conta conta) {
        if (cpfExists(conta)){
            throw new CpfAlreadyExistsException(conta.getCpf());
        }

        if (emailExists(conta)){
            throw new EmailAlreadyExistsException(conta.getEmail());
        }

        return true;
    }

    private boolean cpfExists(Conta conta){
        return repository.existsContaByCpf(conta.getCpf());
    }

    private boolean emailExists(Conta conta){
        return repository.existsContaByEmail(conta.getEmail());
    }
}
