package com.zsk.service;

import com.zsk.pojo.Tag_Table;

import java.util.List;

public interface Tag_TableService {
    /**
     * 创建新的tag内容
     * @param tag_table
     */
    void insert(Tag_Table tag_table);

    /**
     * 查询所有的tag内容
     * @return
     */
    List<Tag_Table> findAll();
}
