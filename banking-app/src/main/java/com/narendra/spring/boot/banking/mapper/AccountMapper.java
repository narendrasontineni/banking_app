package com.narendra.spring.boot.banking.mapper;
import com.narendra.spring.boot.banking.dto.AccountDto;
import com.narendra.spring.boot.banking.entity.Account;

public class AccountMapper {
	
//	public static Account mapToAccount(AccountDto accountDto) {
//		Account account = new Account(accountDto.getId(),accountDto.getAccountHolderName(),accountDto.getBalance());
//		return account;
//		
//	}
	
	// ---if you used record class--you can call directly with filed name of Dto class
	
	public static Account mapToAccount(AccountDto accountDto) {
		Account account = new Account(accountDto.id(),accountDto.accountHolderName(),accountDto.balance());
		return account;
		
	}
	
	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto = new AccountDto(account.getId(),account.getAccountHolderName(),account.getBalance());
		return accountDto;
		
	}

}
