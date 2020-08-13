package com.pinxue.qianwei.repository;

import com.pinxue.qianwei.model.ResourcePath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface ResourcePathRepository extends JpaRepository<ResourcePath,Long> {

}
