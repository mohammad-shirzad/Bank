package entity;

import java.io.Serializable;

public class Card extends Observer implements Serializable {
    private int id;
    private String cardNumber;
    private Customer customer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Card() {
    }

    public Card(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Card(String cardNumber, Customer customer) {
        this.cardNumber = cardNumber;
        this.customer = customer;
    }
}
