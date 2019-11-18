package com.liuen.springcloud.dao;

import com.liuen.springcloud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: liuen
 * @date: 2019-11-17
 * @since:
 **/
@Repository
public interface UserRepo extends JpaRepository<User,Long> {
}
