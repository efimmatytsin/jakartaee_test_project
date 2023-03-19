package ru.hoteladvisors.repository;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import ru.hoteladvisors.entity.AddressEntity;

import java.util.List;
import java.util.Optional;

public interface AddressRepository {
    List<AddressEntity> findAll();

    Optional<AddressEntity> findById(@NotNull Long id);

    AddressEntity create(
            @NotNull String city,
            @NotNull String street,
            String apt,
            @NotNull String building,
            String postalCode
    );
}
