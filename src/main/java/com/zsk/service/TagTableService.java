package com.zsk.service;

import com.zsk.pojo.TagTable;

import java.util.List;

public interface TagTableService {
    /**
     * 创建新的tag内容
     * @param tagTable
     */
    void insert(TagTable tagTable);

    /**
     * 查询所有的tag内容
     * @return
     */
    List<TagTable> findAll();
}
