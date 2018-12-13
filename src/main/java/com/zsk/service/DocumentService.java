package com.zsk.service;

import com.zsk.dto.SaveDocumentDTO;
import com.zsk.pojo.Document;

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

}
