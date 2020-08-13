package com.pinxue.qianwei.service;

import com.pinxue.qianwei.model.ResourcePath;
import com.pinxue.qianwei.repository.ResourcePathRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ResourcePathService {

    @Autowired
    private ResourcePathRepository repository;

    public String getPathByTime(){
        Long time = new Date().getTime();
        String path = "";
        List<ResourcePath> rs = repository.findAll();
        for(ResourcePath resourcePath:rs){
            Long startTime = resourcePath.getStartTime();
            Long endTime = resourcePath.getEndTime();
            if(time>=startTime&&time<endTime){
                path = resourcePath.getPath();
            }
        }
        return path;
    }
}
