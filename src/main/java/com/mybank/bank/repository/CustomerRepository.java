package com.mybank.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mybank.bank.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>, PagingAndSortingRepository<Customer, Long>{

	Customer findByCustomerIdAndPasswordAndStatus(Long customerId, String password,String status);

}
