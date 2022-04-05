package com.khan.org.service;

import com.khan.org.model.Account;

public interface AccountService {
	public abstract void updateAccountBalance(Account account,Long amount);
}
