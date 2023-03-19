package ru.hoteladvisors.mapper;

import org.mapstruct.Mapper;
import ru.hoteladvisors.entity.CompanyEntity;
import ru.hoteladvisors.model.Company;

import java.util.List;

@Mapper(uses = {AddressMapper.class, BranchMapper.class})
public interface CompanyMapper {
    Company toModel(CompanyEntity company);
    List<Company> toModel(List<CompanyEntity> companyList);
}
