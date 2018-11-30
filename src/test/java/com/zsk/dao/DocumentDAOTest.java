package com.zsk.dao;

import com.zsk.pojo.Category;
import com.zsk.pojo.Document;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;


/** Document测试类
 * @author 夜尽
 * @date 2018/11/29 14:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DocumentDAOTest {
    @Autowired
    DocumentDAO documentDAO;
    @Autowired
    CategoryDao categoryDao;
    
    @Test
    public void save(){
        Document document = new Document();
        Category category = categoryDao.findOne(1);
        document.setDocTitle("标题a");
        document.setDocContent("正文");
        document.setReadSize(1);
        document.setTagName("999");
        document.setCategory(category);
        document.setStatus(3);
        document.setGroupId(999);
        documentDAO.save(document);
    }
    
    @Test
    @Transactional
    public void findOne(){
        Document document = new Document();
        document = documentDAO.findOne(1);
        Category category = document.getCategory();
        System.out.println(category);
    }
    
    @Test
    public void update(){
        Document document = documentDAO.findOne(4);
        document.setDocContent("修改后的正文");
        documentDAO.save(document);
    }
    
    @Test
    public void delete(){
        documentDAO.delete(4);
    }
    
    @Test
    public void findByTitltLike(){
        PageRequest request = new PageRequest(0,5);
        Page<Document> documentPage = documentDAO.findByDocTitleLike("%"+"标题"+"%",request);
        Assert.assertEquals(2,documentPage.getTotalElements());
    }
    
    @Test
    public void findByDocContentLike(){
        PageRequest request = new PageRequest(0,5);
        Page<Document> documentPage = documentDAO.findByDocContentLike("%"+"正文"+"%",request);
        Assert.assertEquals(2,documentPage.getTotalElements());
    }
    
    @Test
    public void findByStatus(){
        PageRequest request = new PageRequest(0,5);
        Page<Document> documentPage = documentDAO.findByStatus(1,request);
        Assert.assertEquals(1,documentPage.getTotalElements());
    }
}