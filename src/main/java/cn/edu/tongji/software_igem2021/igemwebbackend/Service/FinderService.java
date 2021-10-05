package cn.edu.tongji.software_igem2021.igemwebbackend.Service;

import cn.edu.tongji.software_igem2021.igemwebbackend.Entity.ScoreWithNameEntity;
import cn.edu.tongji.software_igem2021.igemwebbackend.Repository.FinderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class FinderService {
    @Resource
    FinderRepository finderRepository;

    public List<ScoreWithNameEntity> searchForAll(String key) {

        Specification<ScoreWithNameEntity> spec = (root, criteriaQuery, criteriaBuilder) -> {
            ArrayList<Predicate> list = new ArrayList<>();
            if (!Objects.equals(key, "") && key != null) {
                Predicate bac_id = criteriaBuilder.like(root.get("genebankId").as(String.class), key);
                Predicate phage_id = criteriaBuilder.like(root.get("phageId").as(String.class), key);
                Predicate phage_name = criteriaBuilder.like(root.get("scientificName").as(String.class), "%" + key + "%");
                Predicate bac_name = criteriaBuilder.like(root.get("name").as(String.class), "%" + key + "%");

                list.add(bac_id);
                list.add(bac_name);
                list.add(phage_id);
                list.add(phage_name);
            }

            Predicate[] array = new Predicate[list.size()];
            Predicate[] predicates = list.toArray(array);

            return criteriaBuilder.or(predicates);
        };

        return finderRepository.findAll(spec);
    }

    public List<ScoreWithNameEntity> searchForBacteria(String key) {
        return finderRepository.findAll(
                (Specification<ScoreWithNameEntity>) (root, criteriaQuery, criteriaBuilder) -> {
                    ArrayList<Predicate> list = new ArrayList<>();
                    if (!Objects.equals(key, "") && key != null) {
                        Predicate bac_id = criteriaBuilder.like(root.get("genebankId").as(String.class), key);
                        Predicate bac_name = criteriaBuilder.like(root.get("name").as(String.class), "%" + key + "%");
                        Predicate bac_txid = criteriaBuilder.equal(root.get("bacteriaTxid").as(String.class), key);

                        list.add(bac_id);
                        list.add(bac_name);
                        list.add(bac_txid);
                    }

                    Predicate[] array = new Predicate[list.size()];
                    Predicate[] predicates = list.toArray(array);

                    return criteriaBuilder.or(predicates);
                });
    }

    public List<ScoreWithNameEntity> searchForPhage(String key) {
        return finderRepository.findAll(new Specification<ScoreWithNameEntity>() {
            @Override
            public Predicate toPredicate(Root<ScoreWithNameEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                ArrayList<Predicate> list = new ArrayList<>();
                if (!Objects.equals(key, "") && key != null) {
                    Predicate phage_id = criteriaBuilder.like(root.get("phageId").as(String.class), key);
                    Predicate phage_name = criteriaBuilder.like(root.get("scientificName").as(String.class), "%" + key + "%");
                    Predicate phage_txid = criteriaBuilder.equal(root.get("scientificName").as(String.class), key);

                    list.add(phage_id);
                    list.add(phage_name);
                    list.add(phage_txid);
                }

                Predicate[] array = new Predicate[list.size()];
                Predicate[] predicates = list.toArray(array);

                return criteriaBuilder.or(predicates);
            }
        });
    }
}
