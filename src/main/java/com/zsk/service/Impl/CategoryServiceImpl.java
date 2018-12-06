package com.zsk.service.Impl;

import com.zsk.dao.CategoryDao;
import com.zsk.pojo.Category;
import com.zsk.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao  categoryDao;
    /**
     * 查询所有的文档类型
     * @return
     */
    @Override
    public Map<String, Object> findAll() {
        List<Category> all = categoryDao.findAll();
        Map<String,Object> maps = new HashMap<>();
        maps.put("key",all);
        return maps;
    }

    /**
     * 根据id查询单个
     * @param categoryId
     * @return
     */
    @Override
    public Category findOne(Integer categoryId) {
        return categoryDao.findOne(categoryId);
    }
    /**
     * 创建分类
     * @param category
     */
    @Override
    public void saveCategory(Category category) {
        categoryDao.save(category);
    }
    /**
     * 修改分类
     * @param category
     */
    @Override
    public void updateCategory(Category category) {
        categoryDao.save(category);
    }

    /**
     * 删除类型
     * @param categoryId
     */
    @Override
    public void delectCategory(Integer categoryId) {
        categoryDao.delete(categoryId);
    }
}
