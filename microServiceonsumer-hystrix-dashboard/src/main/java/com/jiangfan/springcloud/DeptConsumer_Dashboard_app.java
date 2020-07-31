package com.jiangfan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * ClassName: DeptConsumer_Dashboard_app
 * Description:
 * date: 2020-7-31 0:41
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumer_Dashboard_app {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_Dashboard_app.class, args);
    }
}
