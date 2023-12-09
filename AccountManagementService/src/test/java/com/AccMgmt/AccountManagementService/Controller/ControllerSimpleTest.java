package com.AccMgmt.AccountManagementService.Controller;


import com.AccMgmt.AccountManagementService.ResponseVOs.SampleResponse;
import com.AccMgmt.AccountManagementService.Service.AccountManagementService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ControllerSimpleTest {

    @Autowired
    private AccountManagementService accountManagementService;

    @Autowired
    private AccountManagementController accountManagementController;

    @Test
    void testGetUserDetailsWithValidUserId() {
        // Assuming you have a valid user ID for testing
        Integer userId = 1;

        // Call the controller method with a valid user ID
        ResponseEntity<?> responseEntity = accountManagementController.getUserDetails(userId);

        // Assert the response: Check that the HTTP status is OK
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        // If you have an expected UserDetailsVo, you can check it as well
        // UserDetailsVo expectedUserDetails = ...; // Set your expected UserDetailsVo
        // assertEquals(expectedUserDetails, responseEntity.getBody());
    }

    @Test
    void testGetUserDetailsWithNullUserId() {
        // Call the controller method with null user ID
        ResponseEntity<?> responseEntity = accountManagementController.getUserDetails(null);

        // Assert the response: Check that the HTTP status is BAD_REQUEST
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());

        // You can add more assertions based on the expected behavior for a null user ID
    }

    @Test
    void testGetUserDetailsWithServiceFailure() {
        // Assuming your service is set up to intentionally fail
        // Set up your service to fail when called with a specific user ID

        // Call the controller method
        ResponseEntity<?> responseEntity = accountManagementController.getUserDetails(1);

        // Assert the response: Check that the HTTP status is INTERNAL_SERVER_ERROR
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertTrue(responseEntity.getBody() instanceof SampleResponse);

        // You can add more assertions based on the expected behavior for a service failure
    }
}

