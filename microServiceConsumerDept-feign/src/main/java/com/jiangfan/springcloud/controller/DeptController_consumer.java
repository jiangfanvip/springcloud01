package com.jiangfan.springcloud.controller;

import com.jiangfan.springcloud.entity.Dept;
import com.jiangfan.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * ClassName: DeptController_consumer
 * Description:
 * date: 2020-7-26 15:14
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@RestController
public class DeptController_consumer {

    @Autowired
    private DeptClientService deptClientService;

    @PostMapping("/consumer/addDept")
    public Integer addDept(Dept dept) {
        //消费生产端的服务
        return deptClientService.addDept(dept);
    }

    @GetMapping("/consumer/getDept/{id}")
    public Dept getDept(@PathVariable Long id) {
        //消费生产端的服务
        return deptClientService.getDept(id);
    }

    @GetMapping("/consumer/getListDept")
    public List<Dept> getDept() {
        //消费生产端的服务
        return deptClientService.getDeptList();
    }


}
