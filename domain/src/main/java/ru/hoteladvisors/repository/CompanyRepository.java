package ru.hoteladvisors.repository;

import jakarta.validation.constraints.NotNull;
import ru.hoteladvisors.entity.AddressEntity;
import ru.hoteladvisors.entity.BranchEntity;
import ru.hoteladvisors.entity.CompanyEntity;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository {

    List<CompanyEntity> findAll();

    Optional<CompanyEntity> findById(@NotNull Long id);

    CompanyEntity create(
            @NotNull String name,
            String legalForm,
            @NotNull AddressEntity address,
            List<BranchEntity> branchList
    );
}
