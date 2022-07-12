package com.springcourse.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springcourse.project.aop.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println("\t" + getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}

	public List<Account> findAccounts() {
		var myAccs = new ArrayList<Account>();

		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("Madhu", "Platinum");
		Account temp3 = new Account("Luca", "Gold");

		myAccs.add(temp1);
		myAccs.add(temp2);
		myAccs.add(temp3);

		return myAccs;
	}

	public boolean doWork() {
		System.out.println("\t" + getClass() + ": doWork()");
		return true;
	}

	public String getName() {
		System.out.println("\t" + getClass() + ": in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println("\t" + getClass() + ": in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println("\t" + getClass() + ": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println("\t" + getClass() + ": in setServiceCode()");
		this.serviceCode = serviceCode;
	}
}
