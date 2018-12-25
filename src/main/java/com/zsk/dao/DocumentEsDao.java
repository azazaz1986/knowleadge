package com.zsk.dao;

import com.zsk.pojo.DocumentEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface DocumentEsDao extends ElasticsearchRepository<DocumentEs,Integer> {
}
