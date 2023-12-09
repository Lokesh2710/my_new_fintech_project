package com.AccMgmt.AccountManagementService.ResponseVOs;

import java.io.Serializable;

public class SampleResponse implements Serializable {

    private String statusMessage;


    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }


}
