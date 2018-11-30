package com.zsk.service;

import com.zsk.pojo.TagTable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TagTableServiceTest {

    @Autowired
    private TagTableService tag_tableService;
    @Test
    public void insert() {
        TagTable tagtable = new TagTable();
        tagtable.setTagID(UUID.randomUUID().toString());
        tagtable.setTagText("ewt");
        tag_tableService.insert(tagtable);
    }

    @Test
    public void findAll() {
        System.out.println(tag_tableService.findAll());
    }
}