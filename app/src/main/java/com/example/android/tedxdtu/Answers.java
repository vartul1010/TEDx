package com.example.android.tedxdtu;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by vartul1010 on 14/4/18.
 */

public class Answers {

    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("why_want_to_attend")
    @Expose
    private String whyWantToAttend;
    @SerializedName("why_idea_worth")
    @Expose
    private String whyIdeaWorth;
    @SerializedName("how_come_to_know")
    @Expose
    private String howComeToKnow;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWhyWantToAttend() {
        return whyWantToAttend;
    }

    public void setWhyWantToAttend(String whyWantToAttend) {
        this.whyWantToAttend = whyWantToAttend;
    }

    public String getWhyIdeaWorth() {
        return whyIdeaWorth;
    }

    public void setWhyIdeaWorth(String whyIdeaWorth) {
        this.whyIdeaWorth = whyIdeaWorth;
    }

    public String getHowComeToKnow() {
        return howComeToKnow;
    }

    public void setHowComeToKnow(String howComeToKnow) {
        this.howComeToKnow = howComeToKnow;
    }

}
