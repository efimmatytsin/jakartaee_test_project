package ru.hoteladvisors.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "branch")
public class BranchEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @OneToOne(optional = false)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressEntity address;

    public Long getId() {
        return id;
    }

    public BranchEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BranchEntity setName(String name) {
        this.name = name;
        return this;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public BranchEntity setAddress(AddressEntity address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return "BranchEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
