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
import ru.hoteladvisors.entity.CompanyEntity;
import ru.hoteladvisors.repository.CompanyRepository;

import java.util.List;
import java.util.Optional;

@Stateless
public class CompanyRepositoryImpl implements CompanyRepository {

    private static final Logger log = LogManager.getLogger(CompanyRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CompanyEntity> findAll() {
        log.debug("find all companies");
        return entityManager.createQuery(
                        "SELECT c FROM CompanyEntity c")
                .getResultList();
    }

    @Override
    public Optional<CompanyEntity> findById(@NotNull Long id) {
        assert id != null;

        log.debug("find company by id {}", id);

        return Optional.ofNullable(
                entityManager.find(CompanyEntity.class, id)
        );
    }

    @Override
    public CompanyEntity create(
            @NotNull String name,
            String legalForm,
            @NotNull AddressEntity address,
            List<BranchEntity> branchList
    ) {
        assert name != null;
        assert address != null && address.getId() != null;

        if (branchList != null) {
            for (BranchEntity branch : branchList) {
                assert branch.getId() != null;
            }
        }

        log.debug("create company {} {} {} {}", name, legalForm, address, branchList);

        entityManager.getTransaction().begin();
        CompanyEntity company = new CompanyEntity();
        company.setName(name);
        company.setLegalForm(legalForm);
        company.setAddress(address);
        company.setBranches(branchList);

        entityManager.persist(company);

        entityManager.getTransaction().commit();

        log.debug("company created {}", company.getId());
        return company;
    }

    public CompanyRepositoryImpl setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
        return this;
    }
}
