package com.jiangfan.springcloud.service;

import com.jiangfan.springcloud.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * ClassName: DeptClientService
 * 面向接口调用
 * Description:由于不止是dept-feign的controller调用，别个模块controller也需要调用，需要抽取出来
 * date: 2020-7-30 0:01
 *
 * @author LENOVO
 * @since JDK 1.8
 */
//@FeignClient(value = "microserviceprovider-dept")
@FeignClient(value = "microserviceprovider-dept",fallbackFactory = DeptClientServiceFallbackFactory.class)
//客户端调用接口的方法时候如果出错了则找 DeptClientServiceFallbackFactory.class
public interface DeptClientService {
    @RequestMapping(value = "/addDept", method = RequestMethod.POST)
    public Integer addDept(Dept dept);

    @GetMapping(value = "/getDept/{id}")
    public Dept getDept(@PathVariable(value = "id") Long id);

    @GetMapping("/getListDept")
    public List<Dept> getDeptList();
}
