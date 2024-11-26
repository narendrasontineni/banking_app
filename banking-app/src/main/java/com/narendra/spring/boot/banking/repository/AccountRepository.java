package com.narendra.spring.boot.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.narendra.spring.boot.banking.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
