package com.bank.data.entity;

import sun.security.pkcs11.wrapper.Constants;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "ADDRESS")
@Entity
@AttributeOverrides(value = {@AttributeOverride(name = "lastModificationDate", column = @Column(name = "LSTCHNGDT")),
        @AttributeOverride(name = "modifiedBy", column = @Column(name = "MDFBY"))})
public class EAddress extends BaseEntity {

    private long id;


    private String country;


    private String province;


    private String city;


    private String street;


    private String alley;


    private int number;

    private String postalCode;

    @Column(name = "POSTCOD")
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_address")
    @SequenceGenerator(name = "seq_address", sequenceName = "seq_address", allocationSize = 1)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "CNTRY")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "PRVNC", nullable = false)
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Column(name = "CTY", nullable = false)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "STRT", nullable = false)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "ALLEY", nullable = false)
    public String getAlley() {
        return alley;
    }

    public void setAlley(String alley) {
        this.alley = alley;
    }

    @Column(name = "NO", nullable = false)
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
