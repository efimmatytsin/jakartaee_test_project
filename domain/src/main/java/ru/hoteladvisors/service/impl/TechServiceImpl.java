package ru.hoteladvisors.service.impl;

import com.github.javafaker.Address;
import com.github.javafaker.Company;
import com.github.javafaker.Faker;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.hoteladvisors.entity.AddressEntity;
import ru.hoteladvisors.entity.BranchEntity;
import ru.hoteladvisors.entity.CompanyEntity;
import ru.hoteladvisors.repository.AddressRepository;
import ru.hoteladvisors.repository.BranchRepository;
import ru.hoteladvisors.repository.CompanyRepository;
import ru.hoteladvisors.service.TechService;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class TechServiceImpl implements TechService {
    private static final Logger log = LogManager.getLogger(TechServiceImpl.class);

    private static final Faker faker = new Faker();

    protected final AddressRepository addressRepository;
    protected final BranchRepository branchRepository;
    protected final CompanyRepository companyRepository;

    @Inject
    public TechServiceImpl(AddressRepository addressRepository,
                           BranchRepository branchRepository,
                           CompanyRepository companyRepository) {
        this.addressRepository = addressRepository;
        this.branchRepository = branchRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public CompanyEntity generateFakeCompany(){
        log.debug("generate fake company");

        Company company = faker.company();

        AddressEntity address = generateFakeAddress();

        List<BranchEntity> branchList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            branchList.add(generateFakeBranch());
        }

        return companyRepository.create(company.name(), company.bs(), address, branchList);
    }

    @Override
    public AddressEntity generateFakeAddress() {
        log.debug("generate fake address");

        Address address = faker.address();

        return addressRepository.create(
                address.city(),
                address.streetAddress(),
                address.streetAddressNumber(),
                address.buildingNumber(),
                address.zipCode()
        );
    }

    @Override
    public BranchEntity generateFakeBranch() {
        log.debug("generate fake branch");

        String name = faker.funnyName().name();

        return branchRepository.create(name, generateFakeAddress());
    }

}
