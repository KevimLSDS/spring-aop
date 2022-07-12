package com.springcourse.project.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.springcourse.project.aspect.MyApiAnalyticsAspect;
import com.springcourse.project.aspect.MyCloudLogAsyncAspect;
import com.springcourse.project.aspect.MyDemoLoggingAspect;
import com.springcourse.project.dao.AccountDAO;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.springcourse.project.dao")
public class DemoConfig {

	@Bean
	MyDemoLoggingAspect getMyDemoLoggingAspect() {
		return new MyDemoLoggingAspect();
	}

	@Bean
	MyApiAnalyticsAspect getMyApiAnalyticsAspect() {
		return new MyApiAnalyticsAspect();
	}

	@Bean
	MyCloudLogAsyncAspect getMyCloudLogAsyncAspect() {
		return new MyCloudLogAsyncAspect();
	}

	@Bean
	AccountDAO getAccountDAO() {
		return new AccountDAO();
	}

}
