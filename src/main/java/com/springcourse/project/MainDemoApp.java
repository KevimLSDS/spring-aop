package com.springcourse.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.springcourse.project.aop.Account;
import com.springcourse.project.aop.DemoConfig;
import com.springcourse.project.dao.AccountDAO;
import com.springcourse.project.dao.MembershipDAO;

@Component
public class MainDemoApp implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		main(args);
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO theAccountDAO = (AccountDAO) context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO theMembershipDAO = (MembershipDAO) context.getBean("membershipDAO", MembershipDAO.class);

		Account myAcc = new Account();
		myAcc.setName("Madhu");
		myAcc.setLevel("Platinum");

		theAccountDAO.addAccount(myAcc, true);
		theAccountDAO.doWork();
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		theAccountDAO.getName();
		theAccountDAO.getServiceCode();

		theMembershipDAO.addSomething();
		theMembershipDAO.goToSleep();

		context.close();
	}

}
