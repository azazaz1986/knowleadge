package com.zsk.controller;

import com.zsk.pojo.Category;
import com.zsk.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("cate")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 查询所有类型，显示在每个查询的页面上
     * @return
     */
    @RequestMapping("/findCategoryList")
    public Map<String, Object> findCategoryAll(){
        return categoryService.findAll();
    }

    /**
     * 分类增加
     * @param category
     */
    @RequestMapping("/saveCategory")
    public String saveCategory(Category category){
        categoryService.saveCategory(category);
        return "redirect:/cate/findCategoryList";
    }

    /**
     * 分类的修改
     * @param category
     */
    @RequestMapping("/updateCategory")
    public String updateCategory(Category category){
        categoryService.updateCategory(category);
        return "redirect:/cate/findCategoryList";
    }

    /**
     * 分类修改
     * @param categoryId
     */
    @RequestMapping("/delectCategory")
    public String delectCategory(Integer categoryId){
        categoryService.delectCategory(categoryId);
        return "redirect:/cate/findCategoryList";
    }
}
