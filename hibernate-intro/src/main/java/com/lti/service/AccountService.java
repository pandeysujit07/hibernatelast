package com.lti.service;
// classes which contain business  logic are commonly referred  to as service classes
// People also use this naming convention in WebServices(SOAP/REST)

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lti.dao.AccountDao;
import com.lti.entity.Account;
import com.lti.entity.Transaction;

public class AccountService {

		public void openAccount(Account acc) {
			AccountDao dao=new AccountDao();
			dao.insertOrUpdate(acc);
			
			//apart from this we might write/execute
		}
		public void withdraw(long acno, double amount) {
	
			AccountDao dao=new AccountDao();
			Account acc=(Account) dao.fetchById(Account.class, acno);
			
			acc.setBalance(acc.getBalance() - amount );
			dao.insertOrUpdate(acc);
			
			Transaction tran=new Transaction();
			tran.setType("withdraw");
			tran.setAmount(amount);
			tran.setDate(new Date());
			
			tran.setAccount(acc);
			dao.insertOrUpdate(tran);
			
			
			
		}
		public void deposit(long acno, double amount) {
			AccountDao dao=new AccountDao();
			Account acc=(Account) dao.fetchById(Account.class, acno);
			
			acc.setBalance(acc.getBalance() + amount );
			dao.insertOrUpdate(acc);
			Transaction tran=new Transaction();
			tran.setType("deposit");
			tran.setAmount(amount);
			tran.setDate(new Date());
			
			tran.setAccount(acc);
			dao.insertOrUpdate(tran);
			
			
		}
		public void tranfer(long fromAcno, long toAcno, double amount) {
			
			AccountDao dao=new AccountDao();
			Account acc1=(Account) dao.fetchById(Account.class,fromAcno);
			Account acc2=(Account) dao.fetchById(Account.class,toAcno);
			
			acc1.setBalance(acc1.getBalance() - amount);
			acc2.setBalance(acc2.getBalance() + amount);
			
			dao.insertOrUpdate(acc1);
			dao.insertOrUpdate(acc2);
			
			Transaction tran1=new Transaction();
			tran1.setType("transfer");
			tran1.setAmount(amount);
			tran1.setDate(new Date());
			tran1.setAccount(acc1);
			
			Transaction tran2=new Transaction();
			tran2.setType("Money Received");
			tran2.setAmount(amount);
			tran2.setDate(new Date());	
			tran2.setAccount(acc2);
				
		}
		public double CheckBalance(long acno) {
			
			AccountDao dao=new AccountDao();
			Account acc=(Account) dao.fetchById(Account.class, acno);
			
			return acc.getBalance();
					
		}
		
		public  List<Transaction> miniStatement(long acno){
		
			AccountDao dao=new AccountDao();
			List<Transaction> list=dao.fetchMiniSatement(acno);
			return list;
		}
		public List<Account> amountOfThousan(double amount) {
			
			AccountDao dao=new AccountDao();
			List<Account> list=dao.fetchAccountsByBalance(amount);
			return list;
			
		}
	public List<Account> amountOfHundred(String type,double amount) {
			
			AccountDao dao=new AccountDao();
			List<Account> list=dao.fetchAccountsByActivity(type,amount);
			return list;
			
		}
		
		
}
