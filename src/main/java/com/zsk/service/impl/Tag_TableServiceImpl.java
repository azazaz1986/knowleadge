package com.zsk.service.impl;

import com.zsk.dao.Tag_TableDao;
import com.zsk.pojo.Tag_Table;
import com.zsk.service.Tag_TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Tag_TableServiceImpl implements Tag_TableService {

    @Autowired
    private Tag_TableDao tag_tableDao;

    /**
     * 创建新的tag内容
     * @param tag_table
     */
    @Override
    public void insert(Tag_Table tag_table) {
        tag_tableDao.save(tag_table);
    }

    /**
     * 查询所有的tag内容
     * @return
     */
    @Override
    public List<Tag_Table> findAll() {
        return tag_tableDao.findAll();
    }
}
