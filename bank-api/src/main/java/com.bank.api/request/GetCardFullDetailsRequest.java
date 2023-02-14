package com.bank.api.request;

public class GetCardFullDetailsRequest extends ServiceRequest{
    private String cardNo;

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    @Override
    public String toString() {
        return "GetCardFullDetailsRequest{" +
                "cardNo='" + cardNo + '\'' +
                "} " + super.toString();
    }
}
