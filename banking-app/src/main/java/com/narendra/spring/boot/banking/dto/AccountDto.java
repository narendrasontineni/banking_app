package com.narendra.spring.boot.banking.dto;

//import lombok.Data;
//
//@Data  // this will generate getters and setter ,constructors but this lombok supports java18
//public class AccountDto {
//	
//	private Long id;
//	private String accountHolderName ;
//	private double balance ;
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getAccountHolderName() {
//		return accountHolderName;
//	}
//	public void setAccountHolderName(String accountHolderName) {
//		this.accountHolderName = accountHolderName;
//	}
//	public double getBalance() {
//		return balance;
//	}
//	public void setBalance(double balance) {
//		this.balance = balance;
//	}
//	public AccountDto(Long id, String accountHolderName, double balance) {
//		super();
//		this.id = id;
//		this.accountHolderName = accountHolderName;
//		this.balance = balance;
//	}
//	public AccountDto() {
//		super();
//	}
//	@Override
//	public String toString() {
//		return "AccountDto [id=" + id + ", accountHolderName=" + accountHolderName + ", balance=" + balance + "]";
//	}
// 
//	
//}

// here this record class creates getter,setters,constructors,to string,hash code all autometically

public record AccountDto(Long id,String accountHolderName,double balance) {
	
}
