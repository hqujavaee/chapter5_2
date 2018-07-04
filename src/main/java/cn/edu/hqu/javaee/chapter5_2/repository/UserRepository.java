package cn.edu.hqu.javaee.chapter5_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.edu.hqu.javaee.chapter5_2.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{
	 /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    User findByUsername(String username);
}
