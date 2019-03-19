package entity;

import util.CompareTool;
import util.FieldValues;

import java.io.Serializable;
import java.util.*;

public class Customer extends Observer implements CompareTool<Customer>, Serializable {
    private List<FieldValues> differences = new ArrayList<>();
    private Set<String> dbCardNumbers = new HashSet<>();
    private Set<String> newCardNumbers = new HashSet<>();

    private int id;
    private String fullName;
    private String nationalId;
    private Date dateOfBirth;
    private Address address;
    private Set<Card> cards;

    public Customer() {
    }

    public Customer(String fullName, String nationalId, Date dateOfBirth) {
        this.fullName = fullName;
        this.nationalId = nationalId;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    private Set<String> getNewlyCreatedCardNumbers(Customer customer) {

        for (Card dbCard : this.cards
                ) {
            dbCardNumbers.add(dbCard.getCardNumber());
        }
        for (Card newCard : customer.cards
                ) {
            newCardNumbers.add(newCard.getCardNumber());
        }
        newCardNumbers.removeAll(dbCardNumbers);
        return newCardNumbers;
    }

    private Set<String> getRemovedCardNumbers(Customer customer) {
        Set<String> dbCardNumbers = new HashSet<>();
        Set<String> newCardNumbers = new HashSet<>();
        for (Card dbCard : this.cards
                ) {
            dbCardNumbers.add(dbCard.getCardNumber());
        }
        for (Card newCard : customer.cards
                ) {
            newCardNumbers.add(newCard.getCardNumber());
        }
        dbCardNumbers.removeAll(newCardNumbers);
        return dbCardNumbers;
    }

    @Override
    public List<FieldValues> compare(Customer customer) {
        if (!this.fullName.equals(customer.fullName)) {
            differences.add(new FieldValues("fullName", this.fullName, customer.fullName));
        }
        if (!this.address.getProvince().equals(customer.address.getProvince())) {
            differences.add(new FieldValues("address.province", this.address.getProvince(), customer.address.getProvince()));
        }
        if (!this.address.getCity().equals(customer.address.getCity())) {
            differences.add(new FieldValues("address.city", this.address.getCity(), customer.address.getCity()));
        }
        if (!this.address.getStreet().equals(customer.address.getStreet())) {
            differences.add(new FieldValues("address.street", this.address.getStreet(), customer.address.getStreet()));
        }
        if (this.address.getNumber() != customer.address.getNumber()) {
            differences.add(new FieldValues("address.number", this.address.getNumber(), customer.address.getNumber()));
        }
        if (getNewlyCreatedCardNumbers(customer).size() != 0) {
            differences.add(new FieldValues("card.number", null, getNewlyCreatedCardNumbers(customer)));
        }
        if (getRemovedCardNumbers(customer).size() != 0) {
            differences.add(new FieldValues("card.number", getRemovedCardNumbers(customer), null));
        }
        return differences;
    }


}
