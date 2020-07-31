package com.jiangfan.springcloud.controller;

import com.jiangfan.springcloud.entity.Dept;
import com.jiangfan.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: DeptController
 * Description:
 * date: 2020-7-26 13:03
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    @Autowired
    private DiscoveryClient client; //服务发现

    @PostMapping("/addDept")
    public Integer addDept(@RequestBody Dept dept) {


        return deptService.addDept(dept);
    }

    @GetMapping("/getDept/{id}")
    public Dept getDept(@PathVariable("id") Long id) {
        return deptService.getDept(id);
    }

    @GetMapping("/getListDept")
    public List<Dept> getListDept() {
        return deptService.getDeptList();
    }

    /**
     * 服务发现
     * @return
     */
    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> list = client.getServices(); //获取eureka所有的注册服务名
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }

}


