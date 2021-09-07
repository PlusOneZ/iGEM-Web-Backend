package cn.edu.tongji.software_igem2021.igemwebbackend.Repository;

import cn.edu.tongji.software_igem2021.igemwebbackend.Entity.BacteriaPhageScoreEntity;
import cn.edu.tongji.software_igem2021.igemwebbackend.Entity.BacteriaPhageScoreEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinderRepository extends JpaRepository<BacteriaPhageScoreEntity, BacteriaPhageScoreEntityPK> {
    public List<BacteriaPhageScoreEntity> findAllByBacteriaTxidOrderByScoreDesc(int bacId);

    public List<BacteriaPhageScoreEntity> findAllByPhageTxidOrderByScoreDesc(int phageId);


}
