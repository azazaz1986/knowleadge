package com.zsk.service;

import com.zsk.pojo.Category;

import java.util.Map;

public interface CategoryService {
    /**
     * 查询所有的文档类型
     * @return
     */
    Map<String, Object> findAll();

    /**
     * 根据id查询单个
     * @param categoryId
     * @return
     */
    Category findOne(Integer categoryId);

    /**
     * 创建分类
     * @param category
     */
    void saveCategory(Category category);

    /**
     * 修改分类
     * @param category
     */
    void updateCategory(Category category);

    /**
     * 删除类型
     * @param categoryId
     */
    void delectCategory(Integer categoryId);
}
