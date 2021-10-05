package cn.edu.tongji.software_igem2021.igemwebbackend.Repository;

import cn.edu.tongji.software_igem2021.igemwebbackend.Entity.BugScoreWithNameEntity;
import cn.edu.tongji.software_igem2021.igemwebbackend.Entity.BugScoreWithNameEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MapRepository
        extends JpaRepository<BugScoreWithNameEntity, BugScoreWithNameEntityPK> {

}
