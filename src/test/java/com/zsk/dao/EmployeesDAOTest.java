package com.zsk.dao;

import com.zsk.pojo.EmployeesDO;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;




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
//    es查询示例
    @Test
    public void testSearch(){
        String query="os";//搜索关键字
        SearchQuery searchQuery = getEntitySearchQuery(0,10,query);
        Page<EmployeesDO> employeesDOPage = employeesDAO.search(searchQuery);
        System.out.println("查询成功");
    }
    
    private SearchQuery getEntitySearchQuery(int start, int size, String searchContent) {
        FunctionScoreQueryBuilder functionScoreQueryBuilder;
        functionScoreQueryBuilder = QueryBuilders.functionScoreQuery()
                .add(QueryBuilders.matchAllQuery(), //查询所有
                        ScoreFunctionBuilders.weightFactorFunction(100))
                .scoreMode("sum")
                //设置权重分最低分
                .setMinScore(10);
        // 设置分页
        Pageable pageable = new PageRequest(start, size);
        return new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(functionScoreQueryBuilder).build();
    }
}