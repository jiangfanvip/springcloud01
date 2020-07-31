package com.jiangfan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * ClassName: DeptProvider8001_app
 * Description:
 * date: 2020-7-26 13:12
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@EnableEurekaClient  //在生产者一端的启动类标注这是eureka的client
@SpringBootApplication
@EnableDiscoveryClient  //服务发现的配置
public class DeptProvider8003_app {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8003_app.class, args);
    }
}
