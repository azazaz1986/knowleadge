package com.zsk.dao;

import com.zsk.pojo.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/** Document 仓库
 * @author 夜尽
 * @date 2018/11/29 14:49
 */

public interface DocumentDAO extends JpaRepository<Document,Integer> {
    
    Page<Document> findByDocTitleLike(String docTitle, Pageable pageable);
    
    Page<Document> findByDocContentLike(String docContent, Pageable pageable);
    
    Page<Document> findByStatus(Integer status, Pageable pageable);
    
//    TODO 根据小组名称查询文档
}
