package com.jiangfan.RuleImpl;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/**
 * ClassName: MySelfRule
 * Description:自定义轮询类，使用了默认的随机轮询机制
 * date: 2020-7-29 21:29
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@Configurable
public class MySelfRule {
   // @Bean
    public IRule myRule() {
        return new RoundRobinRule();
    }
}
