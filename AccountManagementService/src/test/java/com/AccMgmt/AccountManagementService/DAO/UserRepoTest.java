package com.AccMgmt.AccountManagementService.DAO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class UserRepoTest {

    @Autowired
    private AccountManagementDAO dao;

    @Test
    public void isUserExistById() {

        Boolean k = dao.isUserExistById(1);
        assertThat(k).isTrue();
    }

    @AfterEach
    void tearDown() {
        System.out.println("AfterEach");
    }

    @BeforeEach
    void setUp() {
        System.out.println("BeforeEach");
    }
}