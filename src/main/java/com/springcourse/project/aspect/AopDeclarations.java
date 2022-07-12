package com.springcourse.project.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopDeclarations {

	// POINTCUTS
	@Pointcut("execution(* com.springcourse.project.dao.*.*(..))")
	public void forDaoPackage() {
	}

	@Pointcut("execution(* com.springcourse.project.dao.*.get*())")
	public void getter() {
	}

	@Pointcut("execution(* com.springcourse.project.dao.*.set*(..))")
	public void setter() {
	}

	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterOrSetter() {
	}

	@Pointcut("execution(* com.springcourse.project.dao.AccountDAO.findAccounts(..))")
	public void afterReturningAccountList() {

	}
}
