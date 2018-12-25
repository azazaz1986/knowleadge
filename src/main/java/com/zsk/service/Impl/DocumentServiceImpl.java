package com.zsk.service.Impl;


import com.zsk.dao.DocumentDao;
import com.zsk.dao.DocumentEsDao;
import com.zsk.pojo.Document;
import com.zsk.pojo.DocumentEs;
import com.zsk.service.DocumentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentDao documentDAO;
    @Autowired
    private DocumentEsDao documentEsDao;

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
        /**
         * 当状态码为“”，添加知识到Es中
         */
        if (document.getStatus() == 1){
            Document daoOne = documentDAO.findOne(document.getDocId());
            DocumentEs documentEs = new DocumentEs();
            BeanUtils.copyProperties(daoOne,documentEs);
            //todo 写审核状态码
            documentEsDao.save(documentEs);
        }else{
            documentEsDao.delete(document.getDocId());
        }
    }

    /**
     * 删除知识
     * @param documentId
     */
    @Override
    public void delectDocument(Integer documentId) {
        documentDAO.delete(documentId);
        documentEsDao.delete(documentId);

    }

    /**
     * ES中搜索知识
     * @param query
     * @return
     */
    @Override
    public Page<DocumentEs> searchDoc(SearchQuery query) {
        Page<DocumentEs> search = documentEsDao.search(query);
        return search;
    }

    /**
     * 根据ID查询知识
     * @param docId
     * @return
     */
    @Override
    public Document findById(Integer docId) {
        Document document = new Document();
        Document one = documentDAO.findOne(docId);
        BeanUtils.copyProperties(one,document);
        document.setReadSize(one.getReadSize()+1);
        documentDAO.save(document);
        return one;
    }
}
