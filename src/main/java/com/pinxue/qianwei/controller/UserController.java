package com.pinxue.qianwei.controller;

import com.pinxue.qianwei.model.User;
import com.pinxue.qianwei.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/api/qianwei")
public class UserController {


    @Autowired
    private UserService service;

    /**
     * 测试借口
     * @return
     */
    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public String findAll(){
        log.info("操作成功");
        return  "SUCCESS";
    }


    @PostMapping(
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public User  save(@RequestParam(value = "name") String name,@RequestParam(value="mb")String mb){
        return service.save(name,mb);
    }
}
