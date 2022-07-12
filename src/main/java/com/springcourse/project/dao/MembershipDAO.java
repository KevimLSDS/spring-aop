package com.springcourse.project.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addSomething() {
		System.out.println("\t" + getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
	}

	public boolean goToSleep() {
		System.out.println("\t" + getClass() + ": I'm going to sleep now.");
		return true;
	}

}
