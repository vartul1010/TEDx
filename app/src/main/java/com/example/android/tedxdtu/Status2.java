package com.example.android.tedxdtu;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by vartul1010 on 14/4/18.
 */

public class Status2 {
    @SerializedName("selction")
    @Expose
    private Selction selction;
    @SerializedName("questionnaire")
    @Expose
    private Questionnaire questionnaire;
    @SerializedName("payment")
    @Expose
    private Payment payment;

    public Selction getSelction() {
        return selction;
    }

    public void setSelction(Selction selction) {
        this.selction = selction;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
