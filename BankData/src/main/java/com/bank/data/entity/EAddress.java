package com.bank.data.entity;

import sun.security.pkcs11.wrapper.Constants;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "ADDRESS")
@Entity
public class EAddress extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @SequenceGenerator(name = "address_seq", sequenceName = "ADDRESS_SEQ", allocationSize = 1000)
    @Column(name = "ID")
    private long id;

    @Column(name = "CNTRY")
    private String country;

    @Column(name = "PRVNC", nullable = false)
    private String province;

    @Column(name = "CTY", nullable = false)
    private String city;

    @Column(name = "STRT", nullable = false)
    private String street;

    @Column(name = "ALLEY")
    private String alley;

    @Column(name = "NO", nullable = false)
    private int number;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAlley() {
        return alley;
    }

    public void setAlley(String alley) {
        this.alley = alley;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
