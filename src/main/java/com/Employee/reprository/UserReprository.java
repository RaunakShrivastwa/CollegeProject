package com.Employee.reprository;

import com.Employee.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReprository extends JpaRepository<User,Long> {
//    @Query("select u FROM user u WHERE u.email=?1")
    User findByEmail(String email);
    void deleteByEmail(String email);
}
