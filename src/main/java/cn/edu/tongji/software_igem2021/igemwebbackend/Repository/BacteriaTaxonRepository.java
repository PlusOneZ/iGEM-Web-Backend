package cn.edu.tongji.software_igem2021.igemwebbackend.Repository;

import cn.edu.tongji.software_igem2021.igemwebbackend.Entity.BacteriaTaxonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BacteriaTaxonRepository extends JpaRepository<BacteriaTaxonEntity, Integer> {

    @Query(value = "select bt from BacteriaTaxonEntity bt where bt.name like ?1")
    public List<BacteriaTaxonEntity> getBacteriaTaxonBySearchName(String searchName);


}
