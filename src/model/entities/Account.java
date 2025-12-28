package model.entities;

import model.exception.DomainException;

public class Account {

	private Integer numberAccount;
	private String holder;
	private Double balance;
	private Double withDrawLimit;
	
	
	public Account() {
		
	}

	public Account(Integer numberAccount, String holder, Double balance, Double withDrawLimit) {
	
		this.numberAccount = numberAccount;
		this.holder = holder;
		this.balance = balance;
		this.withDrawLimit = withDrawLimit;
	}

	public Integer getNumberAccount() {
		return numberAccount;
	}

	public String getHolder() {
		return holder;
	}

	public Double getBalance() {
		return balance;
	}


	public Double getWithDrawLimit() {
		return withDrawLimit;
	}	
	
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	public void withdraw(double amount) {
		if (amount > withDrawLimit) {
			throw new DomainException("Error, the withdrawal amount must be less than the available withdrawal limit. ");
		}
		if(balance < amount ) { // 
			throw new DomainException("error, insufficient balance");
		}else {
			balance -= amount;
		}
	}
	
	@Override
	public String toString() {
		return holder
				+ ", "
				+ numberAccount
				+", "
				+ String.format("%.2f", getBalance());
	}
}
