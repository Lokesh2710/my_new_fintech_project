package com.AccMgmt.AccountManagementService.DAO;

import com.AccMgmt.AccountManagementService.Entities.UserAccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountManagementDAO extends JpaRepository<UserAccountDetails,Integer> {

    @Query("select case when count(s) > 0  then true else false end from UserAccountDetails s where id =1")
    Boolean isUserExistById(Integer id);
}
