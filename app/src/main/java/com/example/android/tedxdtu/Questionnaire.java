package com.example.android.tedxdtu;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by vartul1010 on 14/4/18.
 */

public class Questionnaire {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("answers")
    @Expose
    private Answers answers;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Answers getAnswers() {
        return answers;
    }

    public void setAnswers(Answers answers) {
        this.answers = answers;
    }

}
