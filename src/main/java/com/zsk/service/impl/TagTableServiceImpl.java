package com.zsk.service.impl;

import com.zsk.dao.TagTableDao;
import com.zsk.pojo.TagTable;
import com.zsk.service.TagTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagTableServiceImpl implements TagTableService {

    @Autowired
    private TagTableDao tag_tableDao;

    /**
     * 创建新的tag内容
     * @param tag_table
     */
    @Override
    public void insert(TagTable tag_table) {
        tag_tableDao.save(tag_table);
    }

    /**
     * 查询所有的tag内容
     * @return
     */
    @Override
    public List<TagTable> findAll() {
        return tag_tableDao.findAll();
    }
}
