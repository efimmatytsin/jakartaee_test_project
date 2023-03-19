package ru.hoteladvisors.repository.impl;

import jakarta.ejb.Singleton;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.constraints.NotNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.hoteladvisors.entity.AddressEntity;
import ru.hoteladvisors.entity.BranchEntity;
import ru.hoteladvisors.repository.BranchRepository;

import java.util.List;
import java.util.Optional;

@Stateless
public class BranchRepositoryImpl implements BranchRepository {

    private static final Logger log = LogManager.getLogger(BranchRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BranchEntity> findAll() {
        log.debug("find all branches");
        return entityManager.createQuery("select b from BranchEntity b")
                .getResultList();
    }

    @Override
    public Optional<BranchEntity> findById(@NotNull Long id) {
        assert id != null;

        log.debug("find by branch by id {}", id);

        return Optional.ofNullable(
          entityManager.find(BranchEntity.class, id)
        );
    }

    @Override
    public BranchEntity create(
            @NotNull String name,
            @NotNull AddressEntity address
    ) {
        assert name != null;
        assert address != null && address.getId() != null;

        log.debug("create branch {} {}", name, address);

        entityManager.getTransaction().begin();
        BranchEntity branch = new BranchEntity();

        branch.setName(name);
        branch.setAddress(address);

        entityManager.persist(branch);

        entityManager.getTransaction().commit();

        log.debug("branch created {}", branch.getId());

        return branch;
    }

    public BranchRepositoryImpl setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
        return this;
    }
}
