package com.jiangfan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * ClassName: microServiceConsumerDeptfeign80_app
 * Description:
 * date: 2020-7-26 16:24
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@SpringBootApplication
@EnableEurekaClient  //开启eureka客户端，可以让消费者从eureka服务注册中心去拿服务
@EnableFeignClients(basePackages = "com.jiangfan.springcloud") //开启feign client  指定service接口包路径
@ComponentScan(basePackages = "com.jiangfan.springcloud") //扫描实体类组件
public class microServiceConsumerDeptfeign80_app {
    public static void main(String[] args) {
        SpringApplication.run(microServiceConsumerDeptfeign80_app.class, args);
    }
}
