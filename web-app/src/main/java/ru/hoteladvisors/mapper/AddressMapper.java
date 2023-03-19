package ru.hoteladvisors.mapper;

import org.mapstruct.Mapper;
import ru.hoteladvisors.entity.AddressEntity;
import ru.hoteladvisors.model.Address;

import java.util.List;

@Mapper
public interface AddressMapper {
    Address toModel(AddressEntity address);
    List<Address> toModel(List<AddressEntity> addressList);
}
