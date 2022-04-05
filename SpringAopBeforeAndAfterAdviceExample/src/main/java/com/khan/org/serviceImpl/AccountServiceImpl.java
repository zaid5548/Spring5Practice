package com.khan.org.serviceImpl;

import com.khan.org.model.Account;
import com.khan.org.service.AccountService;

public class AccountServiceImpl implements AccountService{

	public void updateAccountBalance(Account account, Long amount) {
		System.out.println("Account No: "+account.getAccountNumber()+", Amount: "+amount);
		
	}

}
