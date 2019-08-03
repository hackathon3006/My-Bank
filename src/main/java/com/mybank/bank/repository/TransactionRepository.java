package com.mybank.bank.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mybank.bank.entity.Account;
import com.mybank.bank.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

		  
	  @Query(value =" from Transaction t where fromAccount =:account and transactionType =:transactionType and (transactionDate between :fromDate AND :toDate)") 
	  public Optional<List<Transaction>> getTodaysTransactionList(Account account, String transactionType, LocalDateTime fromDate, LocalDateTime toDate);
	  
	 

}
