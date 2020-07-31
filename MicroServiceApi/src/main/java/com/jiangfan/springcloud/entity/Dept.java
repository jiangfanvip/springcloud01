package com.jiangfan.springcloud.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 每次生成get set 构造方法  toString 要点几次鼠标，
 * 而且实体类发生改变又要重新生成，可以用lombak
 */
@NoArgsConstructor  //无参空构造方法
//@AllArgsConstructor  //全参构造
@Data    //get set
@Accessors(chain = true)   //链式风格访问
public class Dept implements Serializable// entity --orm--- db_table
{
    private Long deptno; // 主键
    private String dname; // 部门名称
    // 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
    private String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }

  
}
