package entity;

import util.CompareTool;
import util.FieldValues;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Address extends Observer implements CompareTool<Address>, Serializable {
    private int id;
    private String province;
    private String city;
    private String street;
    private int number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Address(String province, String city, String street, int number) {
        this.province = province;
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public Address() {
    }

    @Override
    public List<FieldValues> compare(Address address) {
        List<FieldValues> differences = new ArrayList<>();
        if (!this.province.equals(address.province)) {
            differences.add(new FieldValues("PROVINCE", this.province, address.province));
        }
        if (!this.city.equals(address.city)) {
            differences.add(new FieldValues("CITY", this.city, address.city));
        }
        if (!this.street.equals(address.street)) {
            differences.add(new FieldValues("STREET", this.street, address.street));
        }
        if (this.number != address.number) {
            differences.add(new FieldValues("NUMBER", this.number, address.number));
        }
        return differences;
    }
}
