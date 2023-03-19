package ru.hoteladvisors.repository;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.hoteladvisors.BaseTest;
import ru.hoteladvisors.entity.AddressEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AddressRepositoryTest extends BaseTest {

    @Test
    void findAll() {
        // given
        AddressEntity address1 = techService.generateFakeAddress();
        AddressEntity address2 = techService.generateFakeAddress();
        AddressEntity address3 = techService.generateFakeAddress();

        // when
        List<AddressEntity> list = addressRepository.findAll();

        // then
        Assertions.assertNotNull(list);
        Assertions.assertEquals(3, list.size());
    }

    @Test
    void findById() {
        // given
        AddressEntity address1 = techService.generateFakeAddress();

        // when
        Optional<AddressEntity> found = addressRepository.findById(address1.getId());

        // then
        Assertions.assertTrue(found.isPresent());
    }

    @Test
    void findById_id_incorrect() {
        // when
        Optional<AddressEntity> found = addressRepository.findById(-12312L);

        // then
        Assertions.assertFalse(found.isPresent());
    }

    @Test
    void create() {
        // given
        Faker faker = new Faker();
        Address address = faker.address();

        String city = address.city();
        String streetAddress = address.streetAddress();
        String streetAddressNumber = address.streetAddressNumber();
        String buildingNumber = address.buildingNumber();
        String postalCode = address.zipCode();

        // when
        AddressEntity address1 = addressRepository.create(
                city,
                streetAddress,
                streetAddressNumber,
                buildingNumber,
                postalCode);

        //then
        Assertions.assertNotNull(address1);
        Assertions.assertEquals(city, address1.getCity());
        Assertions.assertEquals(streetAddress, address1.getStreet());
        Assertions.assertEquals(streetAddressNumber, address1.getApt());
        Assertions.assertEquals(buildingNumber, address1.getBuilding());
        Assertions.assertEquals(postalCode, address1.getPostalCode());
    }
}