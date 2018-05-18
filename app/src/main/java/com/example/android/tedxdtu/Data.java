package com.example.android.tedxdtu;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by vartul1010 on 14/4/18.
 */

public class Data {

    @SerializedName("status")
    @Expose
    private Status2 status;
    @SerializedName("user_details")
    @Expose
    private UserDetails userDetails;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("error")
    @Expose
    private Error error;

    public Status2 getStatus() {
        return status;
    }

    public void setStatus(Status2 status) {
        this.status = status;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }



}