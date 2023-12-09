package com.AccMgmt.AccountManagementService.Controller;

import com.AccMgmt.AccountManagementService.RequestVOs.UserDetailsVo;
import com.AccMgmt.AccountManagementService.ResponseVOs.SampleResponse;
import com.AccMgmt.AccountManagementService.Service.AccountManagementService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ControllerMockTest {

    @Mock
    private AccountManagementService accountManagementService;

    @InjectMocks
    private AccountManagementController accountManagementController;

    @Test
    void testGetUserDetailsWithValidUserId() {
        // Mock data
        UserDetailsVo userDetailsVo = new UserDetailsVo();
        userDetailsVo.setUserAppId(1); // Set user details based on your actual UserDetailsVo structure

        // Mock service response
        when(accountManagementService.getUserDetailsService(anyInt())).thenReturn(userDetailsVo);

        // Call the controller method
        ResponseEntity<?> responseEntity = accountManagementController.getUserDetails(1);

        // Assert the response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(userDetailsVo, responseEntity.getBody());
    }

    /*@Test
    void testGetUserDetailsWithNullUserId() {
        // Call the controller method with null userId
        ResponseEntity<?> responseEntity = accountManagementController.getUserDetails(null);

        // Assert the response
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());

        // You can add more assertions based on the expected behavior for a null userId
    }

    @Test
    void testGetUserDetailsWithServiceFailure() {
        // Mock service response when there is a failure
        when(accountManagementService.getUserDetailsService(anyInt())).thenThrow(new RuntimeException("Service failure"));

        // Call the controller method
        ResponseEntity<?> responseEntity = accountManagementController.getUserDetails(1);

        // Assert the response
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertTrue(responseEntity.getBody() instanceof SampleResponse);

        // You can add more assertions based on the expected behavior for a service failure
    }*/
}
