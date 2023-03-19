package ru.hoteladvisors.service;

import ru.hoteladvisors.entity.AddressEntity;
import ru.hoteladvisors.entity.BranchEntity;
import ru.hoteladvisors.entity.CompanyEntity;

public interface TechService {
    CompanyEntity generateFakeCompany();

    AddressEntity generateFakeAddress();

    BranchEntity generateFakeBranch();
}
