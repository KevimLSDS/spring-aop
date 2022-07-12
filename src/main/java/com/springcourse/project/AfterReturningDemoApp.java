package com.springcourse.project;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.springcourse.project.aop.Account;
import com.springcourse.project.aop.DemoConfig;
import com.springcourse.project.dao.AccountDAO;

@Component
public class AfterReturningDemoApp implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		main(args);
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO theAccountDAO = (AccountDAO) context.getBean("accountDAO", AccountDAO.class);

		List<Account> theAccounts = theAccountDAO.findAccounts();

		System.out.println("\n\nMain Program: AfterReturningDemoApp");
		System.out.println("----");

		System.out.println(theAccounts + "\n");

		context.close();
	}

}
