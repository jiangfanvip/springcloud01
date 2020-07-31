package com.jiangfan.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: ConfigBean
 * Description:
 * date: 2020-7-26 14:42
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@Configuration
public class ConfigBean {

    @Bean
    //开启客户端(消费端)负载均衡spring cloud ribbon基于NetFlix ribbon实现一套客户端.负载均衡的工具,默认为多服务轮询策略
    @LoadBalanced
    public RestTemplate getRestTemplate() {

        return new RestTemplate();
    }

    //@Bean
    public IRule myRule() {
        return new RandomRule();  //用我们重新选择的随机算法替换默认轮询.
    }
}
