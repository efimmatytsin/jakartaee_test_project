package ru.hoteladvisors;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.FlushModeType;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.hoteladvisors.repository.impl.AddressRepositoryImpl;
import ru.hoteladvisors.repository.impl.BranchRepositoryImpl;
import ru.hoteladvisors.repository.impl.CompanyRepositoryImpl;
import ru.hoteladvisors.service.TechService;
import ru.hoteladvisors.service.impl.TechServiceImpl;

public abstract class BaseTest {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    protected AddressRepositoryImpl addressRepository;
    protected BranchRepositoryImpl branchRepository;
    protected CompanyRepositoryImpl companyRepository;

    protected TechService techService;

    @BeforeEach
    public void init(){
        this.entityManagerFactory = Persistence.createEntityManagerFactory("test");
        this.entityManager = entityManagerFactory.createEntityManager();
        this.entityManager.setFlushMode(FlushModeType.COMMIT);

        this.addressRepository = new AddressRepositoryImpl();
        this.addressRepository.setEntityManager(entityManager);

        this.branchRepository = new BranchRepositoryImpl();
        this.branchRepository.setEntityManager(entityManager);

        this.companyRepository = new CompanyRepositoryImpl();
        this.companyRepository.setEntityManager(entityManager);

        this.techService = new TechServiceImpl(addressRepository, branchRepository, companyRepository);
    }

    @AfterEach
    public void end() {
        entityManager.close();
        entityManagerFactory.close();
    }

}
