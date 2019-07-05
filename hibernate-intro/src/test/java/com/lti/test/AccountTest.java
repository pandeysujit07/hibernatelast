package com.lti.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lti.dao.AccountDao;
import com.lti.entity.Account;
import com.lti.entity.Transaction;
import com.lti.service.AccountService;

public class AccountTest {
	
	
	@Test
	public void testOpenAccount() {
		AccountService accServ=new AccountService();
		Account acc= new Account();
		
		acc.setName("c");
		acc.setType("saving");
		acc.setBalance(3300);
		accServ.openAccount(acc);
		
		//accServ.withdraw(121, 2000);
		//accServ.deposit(121, 1000);
		//accServ.tranfer(122, 121, 1000);
		
		
		//double bal=accServ.CheckBalance(121);
		//System.out.println("Your balance is: " +bal);
	}

	
	@Test
	public void withdraw() {
		AccountService accServ=new AccountService();
		accServ.withdraw(122, 100);
		
	}
	@Test
	public void deposit() {
		AccountService accServ=new AccountService();
		
		accServ.deposit(121, 1000);
		
	}
	@Test
	public void transfer() {
		AccountService accServ=new AccountService();
		accServ.tranfer(122, 121, 1000);
		
	}
	@Test
	public void checkbalance() {
		AccountService accServ=new AccountService();
		double bal=accServ.CheckBalance(121);
		System.out.println("Your balance is: " +bal);
	}
	
	@Test
	public void miniStatement() {
		AccountService accServ=new AccountService();
		List<Transaction> list=accServ.miniStatement(121);
		for(Transaction t: list)
		{
			
			System.out.println(t.getTxno());
			System.out.println(t.getAccount().getName());
			System.out.println(t.getDate());
			System.out.println(t.getAmount());
			System.out.println(t.getType());
			
		}
	}
	
	@Test
	public void thousandBalance() {
		AccountService accServ=new AccountService();
		List<Account> list=accServ.amountOfThousan(1000);
		for(Account a: list)
		{
			
			
			System.out.println(a.getName());
			System.out.println(a.getAcno());
			System.out.println(a.getBalance());
			
		}
	}
	
	@Test
	public void hundredBalance() {
		AccountService accServ=new AccountService();
		List<Account> amt=accServ.amountOfHundred("withdraw",100);
		for(Account a: amt)
		{
			
			
			System.out.println(a.getName());
			System.out.println(a.getAcno());
			System.out.println(a.getBalance());
			
		}
	}
	
}
