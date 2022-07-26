package com.company;

public class SendSms {
private String phone;
private String sms;


public SendSms() {

}




    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }
    public String  toString(){
    return phone +" "+sms;
    }
}
