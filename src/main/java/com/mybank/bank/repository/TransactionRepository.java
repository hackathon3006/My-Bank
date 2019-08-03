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

	
	@Query(value = "from Transaction t where transactionDate BETWEEN :startDate AND :endDate")
	public List<Transaction> getAllBetweenDates(LocalDateTime startDate, LocalDateTime endDate);
	
	
	public Optional<List<Transaction>> findByFromAccountAndTransactionTypeAndTransactionDateAndTransactionDateAndStatus(Account account, String transactionType, LocalDateTime fromDate, LocalDateTime toDate,String status);
	
	 

}
