package com.zsk.dao;

import com.zsk.config.ElasticConfig;
import com.zsk.pojo.EmployeesDO;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.highlight.HighlightBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeesDAOTest {
    @Autowired
    private EmployeesDAO employeesDAO;
    @Autowired
    private ElasticConfig es;
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