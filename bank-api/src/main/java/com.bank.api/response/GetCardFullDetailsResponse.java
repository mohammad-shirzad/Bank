package com.bank.api.response;

import com.bank.api.dto.view.CardViewDto;


public class GetCardFullDetailsResponse extends ServiceResponse {
    private CardViewDto cardView;

    public GetCardFullDetailsResponse(CardViewDto cardView) {
        this.cardView = cardView;
    }

    public CardViewDto getCardView() {
        return cardView;
    }

    public void setCardView(CardViewDto cardView) {
        this.cardView = cardView;
    }

    @Override
    public String toString() {
        return "GetCardFullDetailsResponse{" +
                "cardView=" + cardView +
                '}';
    }
}
