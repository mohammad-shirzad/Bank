package com.bank.domain.data.entity;

import com.bank.domain.data.enums.CustomerType;
import com.bank.domain.data.enums.IdentityType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Table(name = "CNTC")
@Entity
public class EContact implements Serializable {

    private long id;

    private String firstName;


    private String lastName;


    private String identityNo;


    private CustomerType customerType;

    private String customerNo;

    private IdentityType identityType;


    private Date dateOfBirth;


    private EAddress address;


    private List<ECard> cards;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "customer", orphanRemoval = true, cascade = CascadeType.REMOVE)
    public List<ECard> getCards() {
        return cards;
    }

    public void setCards(List<ECard> cards) {
        this.cards = cards;
    }

    @Column(name = "FRSTNAM")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LSTNAM")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "IDNTNO")
    public String getIdentityNo() {
        return identityNo;
    }

    @Column(name = "IDNTNO", unique = true)
    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    @Column(name = "CUSTTYP")
    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Column(name = "CUSTNO")
    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    @Column(name = "IDNTTYP")
    public IdentityType getIdentityType() {
        return identityType;
    }

    public void setIdentityType(IdentityType identityType) {
        this.identityType = identityType;
    }

    @Column(name = "DOB")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESSID")
    public EAddress getAddress() {
        return address;
    }

    public void setAddress(EAddress address) {
        this.address = address;
    }


}


