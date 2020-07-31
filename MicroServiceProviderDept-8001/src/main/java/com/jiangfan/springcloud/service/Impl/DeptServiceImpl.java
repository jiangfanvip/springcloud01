package com.jiangfan.springcloud.service.Impl;

import com.jiangfan.springcloud.dao.DeptDao;
import com.jiangfan.springcloud.entity.Dept;
import com.jiangfan.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: DeptServiceImpl
 * Description:
 * date: 2020-7-26 12:53
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;


    @Override
    public Integer addDept(Dept dept) {
        Integer integer = deptDao.addDept(dept);
        return (int) dept.getDeptno().longValue();
    }

    @Override
    public Dept getDept(Long id) {
        return deptDao.findById(id);
    }

    @Override
    public List<Dept> getDeptList() {
        return deptDao.findAll();
    }
}
