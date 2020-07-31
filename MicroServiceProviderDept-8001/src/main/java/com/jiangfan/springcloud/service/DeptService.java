package com.jiangfan.springcloud.service;

import com.jiangfan.springcloud.dao.DeptDao;
import com.jiangfan.springcloud.entity.Dept;
import com.netflix.discovery.converters.Auto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: DeptService
 * Description:
 * date: 2020-7-26 12:44
 *
 * @author LENOVO
 * @since JDK 1.8
 */

public interface DeptService {


    public Integer addDept(Dept dept);


    public Dept getDept(Long id);

    public List<Dept> getDeptList();
}
