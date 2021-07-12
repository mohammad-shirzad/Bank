package com.bank.exporter.response;

import com.bank.exporter.dto.view.CardViewDto;

public class GetCardFullDetailsResponse extends ServiceResponse{
    private CardViewDto cardView;

    public GetCardFullDetailsResponse(CardViewDto cardView) {
        this.cardView = cardView;
    }

    @Override
    public String toString() {
        return "GetCardFullDetailsResponse{" +
                "cardView=" + cardView +
                "} " + super.toString();
    }
}
