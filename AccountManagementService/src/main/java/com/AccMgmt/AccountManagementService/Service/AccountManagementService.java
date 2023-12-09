package com.AccMgmt.AccountManagementService.Service;

import com.AccMgmt.AccountManagementService.RequestVOs.UserDetailsVo;

public interface AccountManagementService {

    public String addNewUserDetailsService(UserDetailsVo userDetails);

    public UserDetailsVo getUserDetailsService(Integer userId);
    public String deleteUserDetailsService(Integer userId);
}

