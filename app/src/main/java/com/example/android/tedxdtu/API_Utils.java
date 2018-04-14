package com.example.android.tedxdtu;

/**
 * Created by vartul1010 on 9/4/18.
 */

public class API_Utils {

    public static final String BASE_URL = "http://www.tedxdtu.in/api/v1/";

    public static TEDxDTU_Service getService() {
        return RetrofitClient.getClient(BASE_URL).create(TEDxDTU_Service.class);
    }

}
