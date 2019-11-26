package com.bank.data.entity;

import com.bank.data.enums.CustomerType;
import com.bank.data.enums.IdentityType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "CUSTOMER")
@Entity
@NamedStoredProcedureQueries(value =
@NamedStoredProcedureQuery(name = "findCustomers",
        procedureName = "find_customers",
        resultClasses = ECustomer.class,
        parameters = {@StoredProcedureParameter(name = "customerNo", type = String.class),
                @StoredProcedureParameter(name = "identityNo", type = String.class),
                @StoredProcedureParameter(name = "customerTypeValue", type = Character.class),
                @StoredProcedureParameter(name = "identityTypeValue", type = Character.class)}))
@NamedQueries({
        @NamedQuery(name = "customer.findByIdentityNumber"
                , query = "select c from ECustomer c where c.identityNo = :identityNo"),
        @NamedQuery(name = "customer.findByCustomerNumber"
                , query = "select c from ECustomer c where c.customerNo = :customerNo")})
@AttributeOverrides(value = {@AttributeOverride(name = "lastModificationDate", column = @Column(name = "LSTMDFDT")),
        @AttributeOverride(name = "modifiedBy", column = @Column(name = "MDFBY"))})
public class ECustomer extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust_seq")
    @SequenceGenerator(name = "cust_seq", sequenceName = "CUSTOMER_SEQ", allocationSize = 1000)
    @Column(name = "ID")
    private long id;

    @Column(name = "FRSTNAM")
    private String firstName;

    @Column(name = "LSTNAM")
    private String lastName;

    @Column(name = "IDNTNO")
    private String identityNo;

    @Transient
    private CustomerType customerType;

    @Column(name = "CUSTNO")
    private String customerNo;

    @Transient
    private IdentityType identityType;


    @Column(name = "DOB")
    private Date dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ID")
    private EAddress address;

//    @OneToMany(mappedBy = "customer", orphanRemoval = true)
//    private List<Card> cards;

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

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    @Column(name = "CUSTTYPE")
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

    @Column(name = "IDNTTYTYP")
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

//    public List<Card> getCards() {
//        return cards;
//    }
//
//    public void setCards(List<Card> cards) {
//        this.cards = cards;
//    }


}


