package com.zsk.dao;

import com.zsk.pojo.EmployeesDO;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Iterator;


@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeesDAOTest {
    @Autowired
    private EmployeesDAO employeesDAO;
    
    @Test
    public void Test() {
        EmployeesDO employeesDO = new EmployeesDO();
        employeesDO.setEmpNo(123);
        employeesDO.setFirstName("Toms");
        employeesDO.setLastName("jerys");
        employeesDO.setGender("Ms");

        employeesDAO.save(employeesDO);
    }
    @Test
    public void testSearch(){
        String queryString="s";//搜索关键字
        QueryStringQueryBuilder builder=new QueryStringQueryBuilder(queryString);
        Iterable<EmployeesDO> searchResult = employeesDAO.search(builder);
        Iterator<EmployeesDO> iterator = searchResult.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}