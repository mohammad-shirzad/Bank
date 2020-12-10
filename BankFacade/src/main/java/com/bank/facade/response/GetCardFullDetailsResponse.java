package com.bank.facade.response;

import com.bank.data.view.EvCard;

public class GetCardFullDetailsResponse {
    private EvCard evCard;

    public EvCard getEvCard() {
        return evCard;
    }

    public void setEvCard(EvCard evCard) {
        this.evCard = evCard;
    }
}
