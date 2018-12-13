package com.zsk.controller;

import com.zsk.pojo.Document;
import com.zsk.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("doc/")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @RequestMapping("findAll")
    public HashMap<String, Object> findAll(){
        List<Document> all = documentService.findAll();
        HashMap<String, Object> map = new HashMap<>();
        map.put("data",all);
        map.put("code",200);
        map.put("message","查询成功");
        return map;
    }

}
