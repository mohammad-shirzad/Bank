package com.bank.data.entity;

import com.bank.data.enums.CustomerType;
import com.bank.data.enums.IdentityType;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

@Table(name = "CUSTOMER")
@Entity
@NamedQueries({
        @NamedQuery(name = "customer.findCustomer",
                query = "select c from ECustomer c where (:identityNo is null or c.identityNo = :identityNo) and " +
                        "(:customerNo is null or c.customerNo = :customerNo)")})
@AttributeOverrides(value = {@AttributeOverride(name = "lastModificationDate", column = @Column(name = "LSTMDFDT")),
        @AttributeOverride(name = "modifiedBy", column = @Column(name = "MDFBY"))})
public class ECustomer extends BaseEntity {

    @Column(name = "FRSTNAM")
    private String firstName;

    @Column(name = "LSTNAM")
    private String lastName;

    @Column(name = "IDNTNO", unique = true)
    private String identityNo;

    @Transient
    private CustomerType customerType;

    @Id
    @Column(name = "CUSTNO")
    private String customerNo;

    @Transient
    private IdentityType identityType;

    @Column(name = "DOB")
    private Date dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ID")
    private EAddress address;

    @OneToMany(mappedBy = "customer", orphanRemoval = true, cascade = CascadeType.REMOVE)
    private List<ECard> cards;

    public List<ECard> getCards() {
        return cards;
    }

    public void setCards(List<ECard> cards) {
        this.cards = cards;
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

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    @Column(name = "CUSTTYP")
    @Access(value = AccessType.PROPERTY)
    public Character getCustomerTypeValue() {
        return customerType.getValue();
    }

    public void setCustomerTypeValue(Character customerTypeValue) {
        this.customerType = CustomerType.fromValue(customerTypeValue);
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }


    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public IdentityType getIdentityType() {
        return identityType;
    }

    public void setIdentityType(IdentityType identityType) {
        this.identityType = identityType;
    }

    @Column(name = "IDNTYP")
    @Access(value = AccessType.PROPERTY)
    public Character getIdentityTypeValue() {
        return identityType.getValue();
    }

    public void setIdentityTypeValue(Character identityTypeValue) {
        this.identityType = IdentityType.fromValue(identityTypeValue);
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public EAddress getAddress() {
        return address;
    }

    public void setAddress(EAddress address) {
        this.address = address;
    }


}


