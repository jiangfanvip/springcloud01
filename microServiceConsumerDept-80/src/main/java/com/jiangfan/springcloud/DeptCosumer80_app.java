package com.jiangfan.springcloud;

import com.jiangfan.RuleImpl.MySelfRule;
import com.jiangfan.RuleImpl.Random_jf;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * ClassName: DeptCosumer80_app
 * Description:
 * date: 2020-7-26 16:24
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@SpringBootApplication
@EnableEurekaClient  //开启eureka客户端，可以让消费者从eureka服务注册中心去拿服务
@RibbonClient(value = "microserviceprovider-dept", configuration = Random_jf.class) //指定自定义的ribbon算法
public class DeptCosumer80_app {
    public static void main(String[] args) {
        SpringApplication.run(DeptCosumer80_app.class, args);
    }
}
