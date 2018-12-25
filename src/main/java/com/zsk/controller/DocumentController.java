package com.zsk.controller;

import com.zsk.dto.SaveDocumentDTO;
import com.zsk.pojo.Document;
import com.zsk.pojo.DocumentEs;
import com.zsk.service.DocumentService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("doc/")
@Slf4j
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    /**
     * 知识的列表展示(数据库直接查)
     * @return
     */
    @RequestMapping("findAll")
    public HashMap<String, Object> findAll(@RequestParam(value = "start", defaultValue = "0") int start
            ,@RequestParam(value = "size", defaultValue = "5") int size){
        List<Document> all = documentService.findAll();
        HashMap<String, Object> map = new HashMap<>();
        map.put("data",all);
        map.put("code",200);
        map.put("message","查询成功");
        return map;
    }

    /**
     * 修改知识内容
     * @param documentDTO
     * @return
     */
    @RequestMapping("updateDoc")
    public String updateDoc(SaveDocumentDTO documentDTO){
        Document document = new Document();
        BeanUtils.copyProperties(documentDTO,document);
        documentService.updateDocument(document);
        return "redirect:doc/findAll";
    }

    /**
     * 删除知识
     * @param ids
     * @return
     */
    @RequestMapping("delectDoc")
    public String delectDoc(String ids){
        String[] split = ids.split(",");
        for (String s : split) {
            int id = Integer.parseInt(s);
            documentService.delectDocument(id);
        }
        return "redirect:doc/findAll";
    }

    /**
     * 条件查询（ES中知识搜索）
     * @param searchName
     * @param start
     * @param size
     * @return
     */
    @RequestMapping("searchDoc")
    public Page<DocumentEs> searchDoc(String searchName, @RequestParam(value = "start", defaultValue = "0") int start
            , @RequestParam(value = "size", defaultValue = "5") int size){
        log.info(searchName);
        SearchQuery query = getEntitySearchQuery(start, size, searchName);
        Page<DocumentEs> documentEs = documentService.searchDoc(query);
        for (DocumentEs e : documentEs) {
            System.out.println(e.getDocId());
        }
        return documentEs;
    }
    private SearchQuery getEntitySearchQuery(int start, int size, String searchContent) {
        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery()
                .add(QueryBuilders.matchAllQuery(), //查询所有
                        ScoreFunctionBuilders.weightFactorFunction(100))

//                查询条件，但是并未使用，放在这里，为的是将来使用，方便参考，知道如何用
           //     .add(QueryBuilders.matchPhraseQuery("name", searchContent)
//                      ScoreFunctionBuilders.weightFactorFunction(100))
                //设置权重分 求和模式
                .scoreMode("sum")
                //设置权重分最低分
                .setMinScore(10);

        // 设置分页
//        Sort sort  = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(start, size);
        return new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(functionScoreQueryBuilder).build();
    }

    /**
     * 根据ID查询知识
     * @param docId
     * @return
     */
    @RequestMapping("/findById")
    public Document findById(Integer docId){
       Document document =  documentService.findById(docId);
        return document;
    }

}
