package com.zsk.dao;

import com.zsk.pojo.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class CategoryDaoTest {

    @Autowired
    private CategoryDao categoryDao;

    @Test
    public  void  insert(){
        Category category = new Category();
        category.setCategoryText("q1wes");
        categoryDao.save(category);
    }

    @Test
    public void findAll(){
        System.out.println(categoryDao.findAll());
    }
}