package cn.edu.tongji.software_igem2021.igemwebbackend.Repository;

import cn.edu.tongji.software_igem2021.igemwebbackend.Entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
}
