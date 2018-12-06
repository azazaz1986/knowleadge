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

    @RequestMapping("html1")
    public String index(){
        return "index";
    }
    @RequestMapping("creat")
    public String creat(){
        return "creat/creat_document";
    }
    @RequestMapping(value = "docType",method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, Object> findDocType(){
        Map<String, Object> maps = categoryService.findAll();
        log.info("[Controller]——中的文档分类查询" + maps);
        return maps;
    }


    @RequestMapping("creatDocument")
    public void creatDocument(SaveDocumentDTO document){
        Category category = categoryService.findOne(document.getCategory());
        Document doc = new Document();
        BeanUtils.copyProperties(document,doc);
        doc.setCategory(category);
        documentService.saveDocument(doc);
    }
}
