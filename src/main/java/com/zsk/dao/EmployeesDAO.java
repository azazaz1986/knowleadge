package com.zsk.dao;

import com.zsk.pojo.EmployeesDO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EmployeesDAO extends ElasticsearchRepository<EmployeesDO,Integer> {
}
