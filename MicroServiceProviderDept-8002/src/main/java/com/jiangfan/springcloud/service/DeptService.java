package com.jiangfan.springcloud.service;

import com.jiangfan.springcloud.entity.Dept;

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


    public    Integer addDept(Dept dept);


    public Dept getDept(Long id);

    public List<Dept> getDeptList();
}
