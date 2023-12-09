package com.AccMgmt.AccountManagementService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestAccountManagementServiceApplication {

	public static void main(String[] args) {
		//SpringApplication.from(AccountManagementServiceApplication::main).with(TestAccountManagementServiceApplication.class).run(args);
	}

}
