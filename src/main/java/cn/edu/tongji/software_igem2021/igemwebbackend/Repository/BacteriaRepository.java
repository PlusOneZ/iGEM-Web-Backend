package cn.edu.tongji.software_igem2021.igemwebbackend.Repository;

import cn.edu.tongji.software_igem2021.igemwebbackend.Entity.ValidBacteriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BacteriaRepository
        extends JpaRepository<ValidBacteriaEntity, String>,
        JpaSpecificationExecutor<ValidBacteriaEntity> {
}
