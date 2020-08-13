package com.pinxue.qianwei.service;

import com.pinxue.qianwei.model.User;
import com.pinxue.qianwei.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User save(String name,String mb,int calorie){
        User user = new User();
        user.setName(name);
        user.setMb(mb);
        user.setCalorie(calorie);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String dateString = formatter.format(new Date());
        user.setTime(dateString);
        User result = repository.save(user);
        log.info("保存成功");
        return result;
    };
}
