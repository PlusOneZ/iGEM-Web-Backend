package cn.edu.tongji.software_igem2021.igemwebbackend.Repository;

import cn.edu.tongji.software_igem2021.igemwebbackend.Entity.BacteriaTaxonEntity;
import cn.edu.tongji.software_igem2021.igemwebbackend.Entity.PhageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhageTaxonRepository extends JpaRepository<PhageEntity, String> {

    @Query(value = "select pe from PhageEntity pe where pe.scientificName like ?1")
    public List<PhageEntity> getPhageTaxonBySearchName(String searchName);

}
