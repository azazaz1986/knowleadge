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
public class Tag_TableServiceTest {

    @Autowired
    private TagTableService tag_tableService;
    @Test
    public void insert() {
        TagTable tag_table = new TagTable();
        tag_table.setTag_ID(UUID.randomUUID().toString());
        tag_table.setTag_Text("ewt");
        tag_tableService.insert(tag_table);
    }

    @Test
    public void findAll() {
        System.out.println(tag_tableService.findAll());
    }
}