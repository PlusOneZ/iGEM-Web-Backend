package cn.edu.tongji.software_igem2021.igemwebbackend.Repository;

import cn.edu.tongji.software_igem2021.igemwebbackend.Entity.ScoreWithNameEntity;
import cn.edu.tongji.software_igem2021.igemwebbackend.Entity.ScoreWithNameEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FinderRepository
        extends JpaRepository<ScoreWithNameEntity, ScoreWithNameEntityPK>,
        JpaSpecificationExecutor<ScoreWithNameEntity> {

}
