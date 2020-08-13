package com.pinxue.qianwei.repository;

import com.pinxue.qianwei.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByNameAndMb(String name,String mb);
    List<User> findByMb(String mb);
}
