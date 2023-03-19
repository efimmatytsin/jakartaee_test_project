package ru.hoteladvisors.mapper;

import org.mapstruct.Mapper;
import ru.hoteladvisors.entity.BranchEntity;
import ru.hoteladvisors.model.Branch;

import java.util.List;

@Mapper(uses = {AddressMapper.class})
public interface BranchMapper {
    Branch toModel(BranchEntity branch);
    List<Branch> toModel(List<BranchEntity> branchList);
}
