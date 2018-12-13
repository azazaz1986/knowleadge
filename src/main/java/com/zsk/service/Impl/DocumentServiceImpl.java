package com.zsk.service.Impl;


import com.zsk.dao.DocumentDao;
import com.zsk.pojo.Document;
import com.zsk.service.DocumentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentDao documentDAO;


    @Override
    public List<Document> findAll() {
        return documentDAO.findAll();
    }

    /**
     * 添加知识
     * @param doc
     */
    @Override
    public void saveDocument(Document doc) {
        documentDAO.save(doc);
    }

    /**
     * 修改知识
     * @param document
     */
    @Override
    public void updateDocument(Document document) {
        Document one = documentDAO.findOne(document.getDocId());
        BeanUtils.copyProperties(document,one);
        documentDAO.save(one);
    }

    /**
     * 删除知识
     * @param documentId
     */
    @Override
    public void delectDocument(Integer documentId) {
        documentDAO.delete(documentId);

    }
}
