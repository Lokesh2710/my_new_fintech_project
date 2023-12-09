package com.AccMgmt.AccountManagementService.RequestVOs;

import java.io.Serializable;

public class UserDetailsVo implements Serializable {

    private Integer userAppId;

    private String firstName;

    private String middleName;

    private String lastName;

    private String dateOfBirth;

    private String gender;

    private String aadharNumber;

    private String panNo;

    public Integer getUserAppId() {
        return userAppId;
    }

    public void setUserAppId(Integer userAppId) {
        this.userAppId = userAppId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }
}
