package com.khan.org.serviceImpl;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.khan.org.model.Account;
import com.khan.org.service.AccountService;

@Service("accountService")
public class AccountServiceImpl implements AccountService{

	public void updateAccountBalance(Account account, Long amount) {
		System.out.println("Account No: "+account.getAccountNumber()+", Amount: "+amount);
		
	}

}
