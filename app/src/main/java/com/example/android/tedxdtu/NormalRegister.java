package com.example.android.tedxdtu;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by vartul1010 on 14/4/18.
 */

public class NormalRegister {
    @SerializedName("status")
    @Expose
    private Status4 status;

    public Status4 getStatus() {
        return status;
    }

    public void setStatus(Status4 status) {
        this.status = status;
    }

}
