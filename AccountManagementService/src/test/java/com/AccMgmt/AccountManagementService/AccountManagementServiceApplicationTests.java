package com.AccMgmt.AccountManagementService;

import com.AccMgmt.AccountManagementService.DAO.AccountManagementDAO;
import com.AccMgmt.AccountManagementService.Service.AccountManagementService;
import com.AccMgmt.AccountManagementService.ServiceImpl.AccountManagementServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)  // Instead of using this we can use AutoCloseable
//@SpringBootTest
class AccountManagementServiceApplicationTests {

	private AccountManagementServiceImpl accountManagementService;

	@Mock
	private AccountManagementDAO dao;

	//AutoCloseable autoCloseable;


	@BeforeEach
	void setUp(){
		// autoCloseable = MockitoAnnotations.openMocks(this);
		this.accountManagementService = new AccountManagementServiceImpl(this.dao);
	}

	/*@AfterEach
	void setDown(){
		try {
			this.autoCloseable.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		;
	}*/


	@Test
	void contextLoads() {
		accountManagementService.getUserDetailsService(1);
		verify(dao).findById(1);
	}

}
