package ru.hoteladvisors.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.hoteladvisors.BaseTest;
import ru.hoteladvisors.entity.AddressEntity;
import ru.hoteladvisors.entity.BranchEntity;
import ru.hoteladvisors.entity.CompanyEntity;


class TechServiceTest extends BaseTest {
    @Test
    void generateFakeCompany() {
        // when
        CompanyEntity company = techService.generateFakeCompany();

        // then
        Assertions.assertNotNull(company);
        Assertions.assertNotNull(company.getId());
        Assertions.assertNotNull(company.getName());
        Assertions.assertNotNull(company.getAddress());
        Assertions.assertNotNull(company.getBranches());
    }

    @Test
    void generateFakeAddress() {
        // when
        AddressEntity address = techService.generateFakeAddress();

        // then
        Assertions.assertNotNull(address);
        Assertions.assertNotNull(address.getId());
        Assertions.assertNotNull(address.getApt());
        Assertions.assertNotNull(address.getStreet());
        Assertions.assertNotNull(address.getCity());
        Assertions.assertNotNull(address.getPostalCode());
    }

    @Test
    void generateFakeBranch() {
        // when
        BranchEntity branch = techService.generateFakeBranch();
        // then
        Assertions.assertNotNull(branch);
        Assertions.assertNotNull(branch.getId());
        Assertions.assertNotNull(branch.getAddress());
        Assertions.assertNotNull(branch.getName());
    }
}