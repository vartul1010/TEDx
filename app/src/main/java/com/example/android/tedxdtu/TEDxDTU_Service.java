package com.example.android.tedxdtu;

import android.support.v4.media.AudioAttributesCompat;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by vartul1010 on 9/4/18.
 */

public interface TEDxDTU_Service {

    @POST("accounts/questionnaire")
    Call<QuestionnairePostResponse> postQuestionnaire(@Body String answerOne, String answerTwo, String answerThree, String answerFour);

    @Headers({"Content-Type: application/json",
            "Authorization: Token 396b6915b339e392d1f130c260ed57551e360664"})
    @GET("accounts/status")
    Call<StatusResponse> getInfo();

    @Headers({"content-type: application/x-www-form-urlencoded",
            "cache-control: no-cache",
            "postman-token: c88fbbcd-9199-22d5-6851-89753b57f676"})
    @POST("accounts/get_token/")
    Call<NormalLogin> normalLogin(@Body String username, String password);
    
    @Headers({"content-type: application/x-www-form-urlencoded",
            "cache-control: no-cache",
            "postman-token: d5ef3717-b7bb-8e16-090f-5ca2db9c08ea"})
    @POST("accounts/signup/")
    Call<NormalRegister> normalRegister(@Body String username, String email, String password1, String password2);
}
