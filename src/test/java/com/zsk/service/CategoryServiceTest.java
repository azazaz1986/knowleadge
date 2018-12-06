package com.zsk.service;

import com.zsk.pojo.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class CategoryServiceTest {

    @Autowired
    private  CategoryService c;
    @Test
    public void findAll() {
        System.out.println(c.findAll());
    }

    @Test
    public void save(){
        Category category = new Category();
        category.setCategoryId(3);
        category.setDocType(1);
        category.setCategoryText("php");
        category.setWatchStatus(1);
        c.saveCategory(category);
    }
    @Test
    public void update(){
        Category one = c.findOne(2);
        one.setCategoryText("java");
        one.setWatchStatus(1);
        c.updateCategory(one);
    }
    @Test
    public void delect(){
    c.delectCategory(3);

    }

}