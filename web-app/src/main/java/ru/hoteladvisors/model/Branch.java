package ru.hoteladvisors.model;

public class Branch {
    private Long id;
    private String name;
    private Address address;

    public Long getId() {
        return id;
    }

    public Branch setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Branch setName(String name) {
        this.name = name;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Branch setAddress(Address address) {
        this.address = address;
        return this;
    }
}
