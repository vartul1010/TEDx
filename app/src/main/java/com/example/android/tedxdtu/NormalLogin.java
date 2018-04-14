package com.example.android.tedxdtu;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by vartul1010 on 14/4/18.
 */

public class NormalLogin {

    @SerializedName("status")
    @Expose
    private Status3 status;
    @SerializedName("token")
    @Expose
    private String token;

    public Status3 getStatus() {
        return status;
    }

    public void setStatus(Status3 status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
