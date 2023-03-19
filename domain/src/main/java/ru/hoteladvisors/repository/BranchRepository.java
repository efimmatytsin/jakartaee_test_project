package ru.hoteladvisors.repository;

import jakarta.validation.constraints.NotNull;
import ru.hoteladvisors.entity.AddressEntity;
import ru.hoteladvisors.entity.BranchEntity;

import java.util.List;
import java.util.Optional;

public interface BranchRepository {
    List<BranchEntity> findAll();

    Optional<BranchEntity> findById(@NotNull Long id);

    BranchEntity create(
            @NotNull String name,
            @NotNull AddressEntity address
    );
}
