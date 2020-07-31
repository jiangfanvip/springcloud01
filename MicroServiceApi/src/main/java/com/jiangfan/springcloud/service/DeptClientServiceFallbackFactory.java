package com.jiangfan.springcloud.service;

import com.jiangfan.springcloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ClassName: DeptClientServiceFallbackFactory
 * Description:实现了FallbackFactory接口，参数化类型传入DeptClientService 客户端的service类,所以就是针对这个service的累
 * 进行降级处理
 * date: 2020-7-30 22:40
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@Component  //注册到ioc容器
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            /**
             * 这样子就实现了解耦，不需要在供应者的controller层来处理,当这个服务发生异常时候会进行降级处理，把资源让出来
             * 给别的服务使用，这个别个来请求这个服务的时候会返回一条所以信息回去
             * @param id
             * @return
             */
            @Override
            public Dept getDept(Long id) {
                return new Dept().setDeptno(id).setDname(id + "部门为null.....没有对应信息..." + "此provider已关闭---提供降级处理----" + throwable.getMessage());
            }

            @Override
            public Integer addDept(Dept dept) {
                return null;
            }

            @Override
            public List<Dept> getDeptList() {
                return null;
            }
        };
    }
}
