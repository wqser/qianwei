package com.pinxue.qianwei.controller;

import com.pinxue.qianwei.model.ResourcePath;
import com.pinxue.qianwei.model.User;
import com.pinxue.qianwei.service.ResourcePathService;
import com.pinxue.qianwei.service.UserService;
import com.pinxue.qianwei.viewBuild.ResourcePathView;
import com.pinxue.qianwei.viewBuild.ResourcePathViewBuild;
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
public class Controller {


    @Autowired
    private UserService userService;

    @Autowired
    private ResourcePathService resourcePathService;

    @Autowired
    private ResourcePathViewBuild resourcePathViewBuild;

    /**
     * 测试接口
     * @return
     */
    @GetMapping(
            value = "/test",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public String findAll(){
        log.info("操作成功");
        return  "SUCCESS";
    }

    /**
     * 提交功能
     * @param name
     * @param mb
     * @return
     */
    @PostMapping(
            value = "/register",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public User  save(@RequestParam(value = "name") String name,@RequestParam(value="mb")String mb)throws Exception{
        return userService.save(name,mb);
    }

    /**
     * 获取路径
     * @return
     */
    @GetMapping(
            value = "/getPath",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public ResourcePathView getPath(){
        ResourcePath result = resourcePathService.getPathByTime();
        return resourcePathViewBuild.build(result);
    }

    /**
     * 提交功能
     * @param name
     * @param mb
     * @return
     */
    @PostMapping(
            value = "/mark",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public User  mark(@RequestParam(value = "name") String name,@RequestParam(value="mb")String mb,@RequestParam(value="calorie")int calorie)throws Exception{
        return userService.mark(name,mb,calorie);
    }
}
