package ru.hoteladvisors.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "address")
public class AddressEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "city", nullable = false)
    private String city;

    @NotNull
    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "apt")
    private String apt;

    @NotNull
    @Column(name = "building", nullable = false)
    private String building;

    @Column(name = "postal_code")
    private String postalCode;

    public Long getId() {
        return id;
    }

    public AddressEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCity() {
        return city;
    }

    public AddressEntity setCity(String city) {
        this.city = city;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public AddressEntity setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getApt() {
        return apt;
    }

    public AddressEntity setApt(String apt) {
        this.apt = apt;
        return this;
    }

    public String getBuilding() {
        return building;
    }

    public AddressEntity setBuilding(String building) {
        this.building = building;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public AddressEntity setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    @Override
    public String toString() {
        return "AddressEntity{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", apt='" + apt + '\'' +
                ", building='" + building + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
