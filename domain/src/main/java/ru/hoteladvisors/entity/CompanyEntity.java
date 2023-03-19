package ru.hoteladvisors.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "company")
public class CompanyEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "legal_form")
    private String legalForm;

    @NotNull
    @OneToOne(optional = false)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressEntity address;

    @OneToMany
    @JoinTable(
            name = "company_branch",
            joinColumns = {
                    @JoinColumn(name = "company_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "branch_id", referencedColumnName = "id")
            }
    )
    private List<BranchEntity> branches;

    public Long getId() {
        return id;
    }

    public CompanyEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CompanyEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getLegalForm() {
        return legalForm;
    }

    public CompanyEntity setLegalForm(String legalForm) {
        this.legalForm = legalForm;
        return this;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public CompanyEntity setAddress(AddressEntity address) {
        this.address = address;
        return this;
    }

    public List<BranchEntity> getBranches() {
        return branches;
    }

    public CompanyEntity setBranches(List<BranchEntity> branches) {
        this.branches = branches;
        return this;
    }

    @Override
    public String toString() {
        return "CompanyEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", legalForm='" + legalForm + '\'' +
                ", address=" + address +
                ", branches=" + branches +
                '}';
    }
}
