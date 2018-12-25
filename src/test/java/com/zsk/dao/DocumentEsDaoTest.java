package com.zsk.dao;

import com.zsk.pojo.Document;
import com.zsk.pojo.DocumentEs;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DocumentEsDaoTest {

    @Autowired
    private DocumentEsDao documentEsDao;

    @Test
    public void save(){
        DocumentEs document = new DocumentEs();
        document.setDocId(12);
        document.setDocContent("34234535");
        document.setDocTitle("12");
        documentEsDao.save(document);
    }

    @Test
    public void testSearch(){
        String queryString="123";//搜索关键字
        QueryStringQueryBuilder builder=new QueryStringQueryBuilder(queryString);
        Iterable<DocumentEs> searchResult = documentEsDao.search(builder);
        Iterator<DocumentEs> iterator = searchResult.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}