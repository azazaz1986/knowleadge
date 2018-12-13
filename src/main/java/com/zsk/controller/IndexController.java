package com.zsk.controller;

import com.zsk.dto.SaveDocumentDTO;
import com.zsk.pojo.Category;
import com.zsk.pojo.Document;
import com.zsk.service.CategoryService;
import com.zsk.service.DocumentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("index/")
@Slf4j
public class IndexController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private DocumentService documentService;

    /**
     * 页面跳转，跳转index页面
     * @return
     */
    @RequestMapping("html1")
    public String index(){
        return "index";
    }

    /**
     * 页面跳转，跳转知识添加页面
     * @return
     */
    @RequestMapping("creat")
    public String creat(){
        return "doc/creat_document";
    }

    /**
     * 页面跳转，跳转管理页面
     * @return
     */
    @RequestMapping("admin")
    public String admin(){
        return "doc/admin";
    }

    /**
     * 知识添加页面请求数据，获取知识类型
     * @return
     */
    @RequestMapping(value = "docType",method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, Object> findDocType(){
        Map<String, Object> maps = categoryService.findAll();
        log.info("[Controller]——中的文档分类查询" + maps);
        return maps;
    }

    /**
     * 添加知识
     * @param document
     */
    @RequestMapping("creatDocument")
    public void creatDocument(SaveDocumentDTO document){
        Category category = categoryService.findOne(document.getCategory());
        Document doc = new Document();
        BeanUtils.copyProperties(document,doc);
        doc.setCategory(category);
        documentService.saveDocument(doc);
    }
}
