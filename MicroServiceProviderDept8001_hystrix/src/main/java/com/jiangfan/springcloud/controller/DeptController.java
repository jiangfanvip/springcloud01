package com.jiangfan.springcloud.controller;

import com.jiangfan.springcloud.entity.Dept;
import com.jiangfan.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    // @Autowired
    private DiscoveryClient client; //服务发现

    @PostMapping("/addDept")
    public Integer addDept(@RequestBody Dept dept) {


        return deptService.addDept(dept);
    }

    @GetMapping("/getDept/{id}")
    //@HystrixCommand(fallbackMethod = "processHystrix_Get")
    //一旦调用服务发生异常抛出错误消息后，会自动调用 @HystrixCommand(fallbackMethod = "processHystrix_Get")注解fallbackMethod标注好的方法
    public Dept getDept(@PathVariable("id") Long id) {
        Dept dept = deptService.getDept(id);
        if (dept == null) {  //当这个供应者发生异常 ，发生异常后为了不影响调用他的服务，可以自动调用到fallbackMethod指定方法正常执行且返回
            throw new RuntimeException(id + "部门为null.....没有对应信息...");
        }

        return dept;
    }

//    public Dept processHystrix_Get(@PathVariable("id") Long id) {
//        return new Dept().setDeptno(id).setDname("该" + id + "没有对应信息----@hystrix---");
//    }

    @GetMapping("/getListDept")
    public List<Dept> getListDept() {
        return deptService.getDeptList();
    }

    /**
     * 服务发现
     *
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


