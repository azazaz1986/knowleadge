package com.zsk.dao;

import com.zsk.pojo.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class CategoryDaoTest {

    @Autowired
    private CategoryDao categoryDao;

    @Test
    public void insert(){
        Category category = new Category();
        category.setCategoryText("我是分类1");
        categoryDao.save(category);
    }

    @Test
    @Transactional
    public void find(){
        System.out.println(categoryDao.findOne(1));
    }
    
    @Test
    public void delete(){
        categoryDao.delete(1);
    }
}