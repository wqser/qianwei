package com.pinxue.qianwei.service;

import com.pinxue.qianwei.model.User;
import com.pinxue.qianwei.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User save(String name,String mb){
        User user = new User();
        user.setName(name);
        user.setMb(mb);
        User result = repository.save(user);
        log.info("保存成功");
        return result;
    };
}