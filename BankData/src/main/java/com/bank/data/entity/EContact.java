package com.bank.data.entity;

import com.bank.data.enums.CustomerType;
import com.bank.data.enums.IdentityType;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

@Table(name = "CNTC")
@Entity
@NamedQueries({
        @NamedQuery(name = "customer.findCustomer",
                query = "select c from EContact c where " +
                        "(:customerNo is null or c.customerNo = :customerNo) and " +
                        "(:holderId is null or c.id = :holderId)")})
@AttributeOverrides(value = {@AttributeOverride(name = "lastModificationDate", column = @Column(name = "LSTCHNGDT")),
        @AttributeOverride(name = "modifiedBy", column = @Column(name = "MDFBY"))})
public class EContact extends BaseEntity {

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cntc")
    @SequenceGenerator(name = "seq_cntc", sequenceName = "seq_cntc", allocationSize = 1)
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
    public Character getCustomerTypeValue() {
        return customerType.getValue();
    }

    public void setCustomerTypeValue(Character customerTypeValue) {
        this.customerType = CustomerType.fromValue(customerTypeValue);
    }

    @Transient
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

    @Transient
    public IdentityType getIdentityType() {
        return identityType;
    }

    public void setIdentityType(IdentityType identityType) {
        this.identityType = identityType;
    }

    @Column(name = "IDNTTYP")
    public Character getIdentityTypeValue() {
        return identityType.getValue();
    }

    public void setIdentityTypeValue(Character identityTypeValue) {
        this.identityType = IdentityType.fromValue(identityTypeValue);
    }

    @Column(name = "DOB")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESSID", referencedColumnName = "ID")
    public EAddress getAddress() {
        return address;
    }

    public void setAddress(EAddress address) {
        this.address = address;
    }


}


