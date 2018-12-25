package com.zsk.service;

import com.zsk.pojo.Document;
import com.zsk.pojo.DocumentEs;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

import java.util.List;


public interface DocumentService {
   /**
    * 查询知识
    * @return
    */
   List<Document> findAll();
   /**
    * 添加知识
    * @param document
    */
   void saveDocument(Document document);

   /**
    * 修改知识
    * @param document
    */
   void updateDocument(Document document);

   /**
    * 删除知识
    * @param documentId
    */
   void delectDocument(Integer documentId);

   /**\
    * Es知识搜索
    * @param query
    * @return
    */
    Page<DocumentEs> searchDoc(SearchQuery query);

   /**
    * 根据ID查询知识
    * @param docId
    * @return
    */
    Document findById(Integer docId);
}
