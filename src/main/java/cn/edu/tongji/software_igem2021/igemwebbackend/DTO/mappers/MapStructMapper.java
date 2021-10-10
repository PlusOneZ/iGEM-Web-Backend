package cn.edu.tongji.software_igem2021.igemwebbackend.DTO.mappers;

import cn.edu.tongji.software_igem2021.igemwebbackend.DTO.BacAndPhageInfo;
import cn.edu.tongji.software_igem2021.igemwebbackend.Entity.ValidBacteriaEntity;
import cn.edu.tongji.software_igem2021.igemwebbackend.Entity.ValidPhageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@Mapper
public interface MapStructMapper {

    MapStructMapper INSTANCE = Mappers.getMapper(MapStructMapper.class);

    List<BacAndPhageInfo> allToBacAndPhageInfo(List<ValidBacteriaEntity> bacterias);

    List<BacAndPhageInfo> allToBacAndPhageInfo(Collection<ValidPhageEntity> phages);
}
