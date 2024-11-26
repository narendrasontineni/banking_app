package com.narendra.spring.boot.banking.service;

import java.util.List;

import com.narendra.spring.boot.banking.dto.AccountDto;

public interface AccountService {
	
	AccountDto createAccount(AccountDto accountDto);
	
	AccountDto getAccountById(Long id);
	
	AccountDto deposit(Long id , double ammount);
	
	AccountDto withdraw(Long id,double amount);
	
	List<AccountDto> getAllAccounts();
	
	void deleteAccount(Long id);

}
