package com.mybank.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mybank.bank.entity.Payee;

@Repository
public interface PayeeRepository extends JpaRepository<Payee, Long>{
	
	public List<Payee> findPayeeByPayerAccountId(Long payerAccountId);

}
