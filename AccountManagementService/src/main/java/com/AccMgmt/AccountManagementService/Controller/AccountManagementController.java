package com.AccMgmt.AccountManagementService.Controller;

import com.AccMgmt.AccountManagementService.Constants.AccountManagementConstants;
import com.AccMgmt.AccountManagementService.RequestVOs.UserDetailsVo;
import com.AccMgmt.AccountManagementService.ResponseVOs.SampleResponse;
import com.AccMgmt.AccountManagementService.Service.AccountManagementService;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import static com.AccMgmt.AccountManagementService.Constants.AccountManagementConstants.STATUS_FAILURE;
import static com.AccMgmt.AccountManagementService.Constants.AccountManagementConstants.STATUS_SUCCESS;

@RestController
@RequestMapping(value = "/accounts")
public class AccountManagementController {

    private static final Logger logger = LogManager.getLogger(AccountManagementController.class);
    @Autowired
    AccountManagementService accountManagementService;

    @PostMapping(value = "/addUserDetails")
    public ResponseEntity<?> addNewUserDetails(@RequestBody UserDetailsVo userDetails) {
        logger.info("Calling AccountManagementController : addNewUserDetails ");
        SampleResponse sampleResponse = new SampleResponse();
        try {
            String check = validateUserDetailsRequest(userDetails);
            if (AccountManagementConstants.VALID.equalsIgnoreCase(check)) {
                accountManagementService.addNewUserDetailsService(userDetails);
                sampleResponse.setStatusMessage("Details Saved Succesfully");
                return new ResponseEntity<>(sampleResponse, HttpStatus.OK);
            } else {
                sampleResponse.setStatusMessage(check);
                return new ResponseEntity<>(sampleResponse, HttpStatus.BAD_GATEWAY);
            }
        } catch (Exception ex) {
            logger.error("getting error while saving User Details : {}", ex);
            sampleResponse.setStatusMessage(ex.getMessage());
        }
        return new ResponseEntity<>(sampleResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(value = "/getUserDetails/{userId}")
    public ResponseEntity<?> getUserDetails(@PathVariable("userId") Integer userId) {
        logger.info("Calling AccountManagementController : getUserDetails ");
        SampleResponse sampleResponse = new SampleResponse();
        UserDetailsVo userDetailsVo = null;
        try {
            if (userId!=null) {
                userDetailsVo = accountManagementService.getUserDetailsService(userId);
                if(userDetailsVo!=null){
                    sampleResponse.setStatusMessage(STATUS_SUCCESS);
                    return new ResponseEntity<>(userDetailsVo, HttpStatus.OK);
                }else{
                    sampleResponse.setStatusMessage(STATUS_FAILURE);
                    return new ResponseEntity<>(sampleResponse, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            } else {
                sampleResponse.setStatusMessage("userId is required");
                return new ResponseEntity<>(sampleResponse, HttpStatus.BAD_GATEWAY);
            }
        } catch (Exception ex) {
            logger.error("getting error while getting User Details : {}", ex);
            sampleResponse.setStatusMessage(ex.getMessage());
        }
        return new ResponseEntity<>(sampleResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping(value = "/deleteUserDetails/{userId}")
    public ResponseEntity<?> deleteUserDetails(@PathVariable("userId") Integer userId) {
        logger.info("Calling AccountManagementController : deleteUserDetails ");
        SampleResponse sampleResponse = new SampleResponse();
        try {
            if (userId!=null) {
                String response = accountManagementService.deleteUserDetailsService(userId);
                if(!response.equalsIgnoreCase(STATUS_FAILURE)){
                    sampleResponse.setStatusMessage(STATUS_SUCCESS);
                    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }else{
                    sampleResponse.setStatusMessage(STATUS_FAILURE);
                    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            } else {
                sampleResponse.setStatusMessage("userId is required");
                return new ResponseEntity<>(sampleResponse, HttpStatus.BAD_GATEWAY);
            }
        } catch (Exception ex) {
            logger.error("getting error while deleting User Details : {}", ex);
            sampleResponse.setStatusMessage(ex.getMessage());
        }
        return new ResponseEntity<>(sampleResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private String validateUserDetailsRequest(UserDetailsVo userDetails) {
        if (ObjectUtils.isEmpty(userDetails)) {
            return "All Details Required";
        } else {
            if (!StringUtils.isNotBlank(userDetails.getFirstName())) {
                return "first Name is required";
            }
        }
        return AccountManagementConstants.VALID;
    }
}
