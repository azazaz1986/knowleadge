package com.zsk.service.Impl;

import com.zsk.dao.DocumentDAO;
import com.zsk.dto.SaveDocumentDTO;
import com.zsk.pojo.Document;
import com.zsk.service.DocumentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;

@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentDAO documentDAO;


    @Override
    public void saveDocument(Document doc) {
        documentDAO.save(doc);
    }

    @Override
    public void updateDocument(Document document) {
        Document one = documentDAO.findOne(document.getDocId());
        BeanUtils.copyProperties(document,one);
        documentDAO.save(one);
    }

    @Override
    public void delectDocument(Integer documentId) {
        documentDAO.delete(documentId);

    }
}
