package io.github.fogeid.zupBank.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import io.github.fogeid.zupBank.entities.Conta;
import io.github.fogeid.zupBank.repositories.ContaRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

	@Autowired
	private ContaRepository contaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Conta c1 = new Conta(null, "Diego Batista", "diego.silva@aluno.ic.ufmt.br", "05115212196", "11/01/1995");
		
		contaRepository.save(c1);
	}
}