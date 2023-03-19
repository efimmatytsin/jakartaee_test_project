package ru.hoteladvisors.repository.impl;

import jakarta.ejb.Singleton;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.hoteladvisors.entity.AddressEntity;
import ru.hoteladvisors.repository.AddressRepository;

import java.util.List;
import java.util.Optional;

@Stateless
public class AddressRepositoryImpl implements AddressRepository {

    private static final Logger log = LogManager.getLogger(AddressRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<AddressEntity> findAll() {
        log.debug("find all addresses in db");
        return entityManager.createQuery(
                        "SELECT a FROM AddressEntity a")
                .getResultList();
    }

    @Override
    public Optional<AddressEntity> findById(@NotNull Long id) {
        assert id != null;

        log.debug("find address by id {}", id);

        return Optional.ofNullable(
                entityManager.find(AddressEntity.class, id)
        );
    }

    @Override
    public AddressEntity create(
            @NotNull String city,
            @NotNull String street,
            String apt,
            @NotNull String building,
            String postalCode
    ) {
        assert city != null;
        assert street != null;
        assert building != null;

        log.debug("create new address entity {} {} {} {} {}", city, street, apt, building, postalCode);

        entityManager.getTransaction().begin();

        AddressEntity address = new AddressEntity();
        address.setApt(apt);
        address.setBuilding(building);
        address.setStreet(street);
        address.setPostalCode(postalCode);
        address.setCity(city);

        entityManager.persist(address);

        entityManager.getTransaction().commit();

        log.debug("address created {}", address.getId());

        return address;
    }

    public AddressRepositoryImpl setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
        return this;
    }
}
