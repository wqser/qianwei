package com.pinxue.qianwei.service;

import com.pinxue.qianwei.exception.DuplicateMbException;
import com.pinxue.qianwei.model.User;
import com.pinxue.qianwei.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    /**
     * 注册保存的数据
     * @param name
     * @param mb
     * @return
     */
    public User save(String name,String mb) throws DuplicateMbException{
        List<User> users = repository.findByMb(mb);
        if(users.size() > 0){
            throw new DuplicateMbException("此电话已注册！");
        }else{
            User user = new User();
            user.setName(name);
            user.setMb(mb);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
            String dateString = formatter.format(new Date());
            user.setTime(dateString);
            User result = repository.save(user);
            log.info("保存成功");
            return result;
        }
//        User user = new User();
//        user.setName(name);
//        user.setMb(mb);
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
//        String dateString = formatter.format(new Date());
//        user.setTime(dateString);
//        User result = repository.save(user);
//        log.info("保存成功");
//        return result;

    };

    /**
     * 打卡签到
     * @param name
     * @param mb
     * @return
     */
    public User mark (String name,String mb,double calorie)throws Exception{
//        User user = repository.findByNameAndMb(name,mb);
//        if(user == null){
//            throw new Exception("该客户未注册");
//        }
//        user.setCalorie(calorie);
//        return repository.saveAndFlush(user);
        User user = new User();
        user.setName(name);
        user.setMb(mb);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String dateString = formatter.format(new Date());
        user.setTime(dateString);
        user.setCalorie(calorie);
        return repository.saveAndFlush(user);

    };
}
