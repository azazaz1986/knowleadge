package com.zsk.service;

import com.zsk.dto.SaveDocumentDTO;
import com.zsk.pojo.Document;


public interface DocumentService {

   void saveDocument(Document document);

   void updateDocument(Document document);

   void delectDocument(Integer documentId);

}
