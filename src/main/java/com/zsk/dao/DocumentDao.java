package com.zsk.dao;

import com.zsk.pojo.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/** Document 仓库
 * @author 夜尽
 * @date 2018/11/29 14:49
 */

public interface DocumentDao extends JpaRepository<Document,Integer> {
    /**
     * 根据知识标题进行查询
     * @param docTitle
     * @param pageable
     * @return
     */
    Page<Document> findByDocTitleLike(String docTitle, Pageable pageable);

    /**
     * 根据知识内容进行查询
     * @param docContent
     * @param pageable
     * @return
     */
    Page<Document> findByDocContentLike(String docContent, Pageable pageable);

    /**
     * 根据知识状态进项查询
     * @param status
     * @param pageable
     * @return
     */
    Page<Document> findByStatus(Integer status, Pageable pageable);
    
//    TODO 根据小组名称查询文档
}
