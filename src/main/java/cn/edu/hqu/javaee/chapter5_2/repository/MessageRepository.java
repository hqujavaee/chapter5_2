package cn.edu.hqu.javaee.chapter5_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cn.edu.hqu.javaee.chapter5_2.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long>{
}
