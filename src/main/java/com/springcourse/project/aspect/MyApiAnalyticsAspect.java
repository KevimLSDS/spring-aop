package com.springcourse.project.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class MyApiAnalyticsAspect {

	@Before("com.springcourse.project.aspect.AopDeclarations.forDaoPackageNoGetterOrSetter()")
	public void performApiAnalytics() {
		System.out.println("\n====>>> Perform API analytics");
	}
}
