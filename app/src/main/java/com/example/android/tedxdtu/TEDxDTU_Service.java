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

}
