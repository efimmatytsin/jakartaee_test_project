package ru.hoteladvisors.view;

import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;
import org.mapstruct.factory.Mappers;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.cdi.DelegatingVariableResolver;
import ru.hoteladvisors.entity.CompanyEntity;
import ru.hoteladvisors.mapper.CompanyMapper;
import ru.hoteladvisors.model.Company;
import ru.hoteladvisors.repository.CompanyRepository;

import java.util.List;

@VariableResolver(DelegatingVariableResolver.class)
public class CompanyViewModel {

    private static CompanyMapper companyMapper = Mappers.getMapper(CompanyMapper.class);

    @WireVariable
    public CompanyRepository companyRepository;

    public List<Company> getCompanies() {
        List<CompanyEntity> entities = companyRepository.findAll();

        return companyMapper.toModel(entities);
    }


}
