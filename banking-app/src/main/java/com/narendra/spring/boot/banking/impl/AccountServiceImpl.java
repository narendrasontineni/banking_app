package com.narendra.spring.boot.banking.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.narendra.spring.boot.banking.dto.AccountDto;
import com.narendra.spring.boot.banking.entity.Account;
import com.narendra.spring.boot.banking.mapper.AccountMapper;
import com.narendra.spring.boot.banking.repository.AccountRepository;
import com.narendra.spring.boot.banking.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	  private AccountRepository accountRepository;
     
	  
	  public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}


	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		
		Account account = AccountMapper.mapToAccount(accountDto);
		
		Account savedAccountDto = accountRepository.save(account);
		
		return AccountMapper.mapToAccountDto(savedAccountDto);
	}


	@Override
	public AccountDto getAccountById(Long id) {
		
	Account account = accountRepository
			.findById(id)
			.orElseThrow(() -> new RuntimeException("Account does not exist"));
		
		return AccountMapper.mapToAccountDto(account);
		
	}


	@Override
	public AccountDto deposit(Long id, double ammount) {
		
		Account account = accountRepository
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exist"));
		double total = account.getBalance()+ammount;
		account.setBalance(total);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}


	@Override
	public AccountDto withdraw(Long id, double amount) {

		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exist"));
		if (account.getBalance() < amount) {
			throw new RuntimeException("Insufficient amount");
		}
		double total = account.getBalance() - amount;
		account.setBalance(total);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}


	@Override
	public List<AccountDto> getAllAccounts() {
		List<Account> accounts = accountRepository.findAll();
		return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
	}


	@Override
	public void deleteAccount(Long id) {

		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exist"));
		accountRepository.deleteById(id);
	}

}
