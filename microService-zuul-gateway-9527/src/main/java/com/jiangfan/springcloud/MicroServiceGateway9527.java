package com.jiangfan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * ClassName: microServiceGateway
 * Description:
 * date: 2020-7-31 1:38
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@SpringBootApplication
@EnableZuulProxy  //开启zuul网关代理
public class MicroServiceGateway9527 {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceGateway9527.class, args);
    }
}
