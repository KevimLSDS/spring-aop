package com.springcourse.project.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.springcourse.project.aop.Account;

@Component
@Aspect
@Order(2)
public class MyDemoLoggingAspect {

	@Before("com.springcourse.project.aspect.AopDeclarations.forDaoPackageNoGetterOrSetter()")
	public void beforeDAOPackageAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n====>>> Executing @Before advice on a method of the DAO package with (any parameters)");

		// DISPLAY THE METHOD SIGNATURE
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();

		System.out.println("\tMethod: " + methodSig);

		// DISPLAY METHOD ARGUMENTS
			// get args
			Object[] args = theJoinPoint.getArgs();
	
			// loop through args
			for (Object tempArg : args) {
				System.out.println("\t" + tempArg);
	
				if (tempArg instanceof Account) {
					// downcast and print Account specific stuff
					Account theAccount = (Account) tempArg;
	
					System.out.println("\tAccount name: " + theAccount.getName());
					System.out.println("\tAccount level: " + theAccount.getLevel());
				}
			}
	}

	@AfterReturning(pointcut = "com.springcourse.project.aspect.AopDeclarations.afterReturningAccountList()", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {

		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n====>>> Executing @AfterReturning on method: " + method);

		System.out.println("\n====>>> Result is: " + result);

		// POST-PROCESS THE DATA
		convertAccountNamesToUpperCase(result);
		System.out.println("\n====>>> Result is: " + result);
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		for (Account tempAcc : result) {
			tempAcc.setName(tempAcc.getName().toUpperCase());
		}

	}
	
	@AfterThrowing(pointcut = "com.springcourse.project.aspect.AopDeclarations.afterReturningAccountList()", throwing="theException")
	public void afterThrowingAdvice(JoinPoint theJoinPoint, Throwable theException) {
		
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n====>>> Executing @AfterThrowing on method: " + method);
		
		System.out.println("\n====>>> The exception is: " + theException);
		
	}

}
















