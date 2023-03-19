package ru.hoteladvisors.model;

import java.util.List;

public class Company {

    private Long id;

    private String name;

    private String legalForm;

    private Address address;

    private List<Branch> branches;

    public Long getId() {
        return id;
    }

    public Company setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    public String getLegalForm() {
        return legalForm;
    }

    public Company setLegalForm(String legalForm) {
        this.legalForm = legalForm;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Company setAddress(Address address) {
        this.address = address;
        return this;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public Company setBranches(List<Branch> branches) {
        this.branches = branches;
        return this;
    }
}
