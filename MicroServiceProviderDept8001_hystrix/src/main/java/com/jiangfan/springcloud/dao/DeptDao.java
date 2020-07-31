package com.jiangfan.springcloud.dao;

import com.jiangfan.springcloud.entity.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * ClassName: DeptDao
 * Description:
 * date: 2020-7-26 11:50
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@Mapper
public interface DeptDao {
    @Options(useGeneratedKeys = true, keyProperty = "d.deptno", keyColumn = "deptno")
    @Insert("insert into dept (dname,db_source) values(#{d.dname},database())")
    public Integer addDept(@Param("id") Dept dept);

    @Select("select  * from  dept  where  deptNo=#{id}")
    public Dept findById(Long id);

    @Select("select  * from  dept")

    public List<Dept> findAll();
}
