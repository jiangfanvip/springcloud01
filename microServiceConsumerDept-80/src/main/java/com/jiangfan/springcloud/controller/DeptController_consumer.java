package com.jiangfan.springcloud.controller;

import com.jiangfan.springcloud.entity.Dept;
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
    // public static final String REST_URL_PREFIX = "http://localhost:8001";
    public static final String REST_URL_PREFIX = "http://microserviceprovider-dept";  //应用程序名

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/consumer/addDept")
    public Integer addDept(Dept dept) {
        //消费生产端的服务
        return restTemplate.postForObject(REST_URL_PREFIX + "/addDept", dept, Integer.class);
    }

    @GetMapping("/consumer/getDept/{id}")
    public Dept getDept(@PathVariable Long id) {
        //消费生产端的服务
        return restTemplate.getForObject(REST_URL_PREFIX + "/getDept/" + id, Dept.class);
    }

    @GetMapping("/consumer/getListDept")
    public List<Dept> getDept() {
        //消费生产端的服务
        return restTemplate.getForObject(REST_URL_PREFIX + "/getListDept", List.class);
    }

    // 测试@EnableDiscoveryClient,消费端可以调用服务发现
    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
    }

}
