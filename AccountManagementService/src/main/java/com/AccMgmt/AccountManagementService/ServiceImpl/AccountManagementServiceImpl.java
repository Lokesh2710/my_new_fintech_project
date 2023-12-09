package com.AccMgmt.AccountManagementService.ServiceImpl;

import com.AccMgmt.AccountManagementService.Constants.AccountManagementConstants;
import com.AccMgmt.AccountManagementService.DAO.AccountManagementDAO;
import com.AccMgmt.AccountManagementService.Entities.UserAccountDetails;
import com.AccMgmt.AccountManagementService.RequestVOs.UserDetailsVo;
import com.AccMgmt.AccountManagementService.Service.AccountManagementService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountManagementServiceImpl implements AccountManagementService {
    private static final Logger logger = LogManager.getLogger(AccountManagementServiceImpl.class);

    @Autowired
    AccountManagementDAO accountManagementDAO;


    public AccountManagementServiceImpl(AccountManagementDAO accountManagementDAO) {
        this.accountManagementDAO = accountManagementDAO;
    }

    public String addNewUserDetailsService(UserDetailsVo userDetails) {
        logger.info("Calling AccountManagementService : addNewUserDetailsService ");
        UserAccountDetails userAccountDetails = new UserAccountDetails();
        try {
            userAccountDetails.setFirstName(userDetails.getFirstName());
            userAccountDetails.setMiddleName(userDetails.getMiddleName());
            userAccountDetails.setLastName(userDetails.getLastName());
            userAccountDetails.setDateOfBirth(userDetails.getDateOfBirth());
            userAccountDetails.setGender(userDetails.getGender());
            userAccountDetails.setAadharNumber(userDetails.getAadharNumber());
            userAccountDetails.setPanNo(userDetails.getPanNo());
            accountManagementDAO.save(userAccountDetails);
        } catch (Exception ex) {
            logger.error("getting error while calling addNewUserDetailsService : {}", ex);
            return AccountManagementConstants.STATUS_FAILURE;
        }
        return AccountManagementConstants.STATUS_SUCCESS;
    }

    @Override
    public UserDetailsVo getUserDetailsService(Integer userId) {
        logger.info("Calling AccountManagementService : getUserDetailsService ");
        UserAccountDetails userAccountDetails = null;
        UserDetailsVo userDetailsVo = null;
        try {
            userAccountDetails = accountManagementDAO.findById(userId).get();
            if (userAccountDetails != null) {
                userDetailsVo = new UserDetailsVo();
                userDetailsVo.setUserAppId(userAccountDetails.getUserAppId());
                userDetailsVo.setFirstName(userAccountDetails.getFirstName());
                userDetailsVo.setMiddleName(userAccountDetails.getMiddleName());
                userDetailsVo.setLastName(userAccountDetails.getLastName());
                userDetailsVo.setDateOfBirth(userAccountDetails.getDateOfBirth());
                userDetailsVo.setGender(userAccountDetails.getGender());
                userDetailsVo.setAadharNumber(userAccountDetails.getAadharNumber());
                userDetailsVo.setPanNo(userAccountDetails.getPanNo());
                return userDetailsVo;
            }
        } catch (Exception ex) {
            logger.error("getting error while calling getUserDetailsService : {}", ex);
        }
        return null;
    }

    @Override
    public String deleteUserDetailsService(Integer userId) {
        logger.info("Calling AccountManagementService : deleteUserDetailsService ");
        UserAccountDetails userAccountDetails = null;
        UserDetailsVo userDetailsVo = null;
        try {
            userAccountDetails = accountManagementDAO.findById(userId).get();

            if (userAccountDetails != null) {
                accountManagementDAO.delete(userAccountDetails);
                return AccountManagementConstants.STATUS_SUCCESS;
            }
        } catch (Exception ex) {
            logger.error("getting error while calling deleteUserDetailsService : {}", ex);
        }
        return AccountManagementConstants.STATUS_FAILURE;
    }
}
