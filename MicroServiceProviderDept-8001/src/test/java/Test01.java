import com.jiangfan.springcloud.entity.Dept;
import com.jiangfan.springcloud.service.DeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ClassName: Test01
 * Description:
 * date: 2020-7-26 17:05
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test01 {
    @Autowired
     private DeptService deptService;
     @Test
    public void   testA(){
        deptService.addDept(new Dept("hello"));

     }
}
