package com.mybank.bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mybank.bank.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

	public Optional<Account> findByAccountNumberAndStatus(Long accountNumber, String status);

}
