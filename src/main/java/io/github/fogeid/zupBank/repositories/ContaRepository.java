package io.github.fogeid.zupBank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.fogeid.zupBank.entities.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

    boolean existsContaByCpf(String cpf);
    boolean existsContaByEmail(String email);
}
