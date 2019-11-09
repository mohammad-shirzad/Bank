package com.bank.data.entity;

import com.bank.data.enums.CustomerType;
import com.bank.data.enums.IdentityType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Table(name = "CUSTOMER")
@Entity
@NamedQueries({
        @NamedQuery(name = "customer.findByIdentityNumber"
                , query = "select c from Customer c where c.identityNumber = :identityNumber"),
        @NamedQuery(name = "customer.findByCustomerNumber"
                , query = "select c from Customer c where c.customerNumber = :customerNumber")})
@AttributeOverrides(value = {@AttributeOverride(name = "lastModificationDate", column = @Column(name = "LSTMDFDT")),
        @AttributeOverride(name = "modifiedBy", column = @Column(name = "MDFBY"))})
public class Customer extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust_seq")
    @SequenceGenerator(name = "cust_seq", sequenceName = "CUSTOMER_SEQ", allocationSize = 1000)
    @Column(name = "ID")
    private long id;

    @Column(name = "FRSTNAM", nullable = false)
    private String firstName;

    @Column(name = "LSTNAM", nullable = false)
    private String lastName;

    @Column(name = "IDNTNO", nullable = false)
    private String identityNumber;

    @Transient
    private CustomerType customerType;

    @Column(name = "CUSTNO", nullable = false)
    private String customerNumber;

    @Transient
    private IdentityType identityType;


    @Column(name = "DOB", nullable = false)
    private Date dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ID")
    private Address address;

//    @OneToMany(mappedBy = "customer", orphanRemoval = true)
//    private List<Card> cards;

    public Customer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    @Column(name = "CUSTTYPE")
    @Access(value = AccessType.PROPERTY)
    public char getCustomerTypeValue() {
        return customerType.getValue();
    }

    public void setCustomerTypeValue(char customerTypeValue) {
        this.customerType = CustomerType.fromValue(customerTypeValue);
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public IdentityType getIdentityType() {
        return identityType;
    }

    public void setIdentityType(IdentityType identityType) {
        this.identityType = identityType;
    }

    @Column(name = "IDNTTYTYP")
    @Access(value = AccessType.PROPERTY)
    public char getIdentityTypeValue() {
        return identityType.getValue();
    }

    public void setIdentityTypeValue(char identityTypeValue) {
        this.identityType = IdentityType.fromValue(identityTypeValue);
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

//    public List<Card> getCards() {
//        return cards;
//    }
//
//    public void setCards(List<Card> cards) {
//        this.cards = cards;
//    }


}


