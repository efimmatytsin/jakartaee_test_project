package ru.hoteladvisors.model;

public class Address {
    private Long id;
    private String city;
    private String street;
    private String apt;
    private String building;
    private String postalCode;

    public Long getId() {
        return id;
    }

    public Address setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getApt() {
        return apt;
    }

    public Address setApt(String apt) {
        this.apt = apt;
        return this;
    }

    public String getBuilding() {
        return building;
    }

    public Address setBuilding(String building) {
        this.building = building;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public Address setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }
}
