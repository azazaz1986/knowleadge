package com.zsk.pojo;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Date;

/** 文档实体类
 * @author 夜尽
 * @date 2018/11/29 14:40
 */
@Entity
@Data
@DynamicUpdate
public class Document implements Serializable {
    private static final long serialVersionUID = -8033450866659078468L;
    @Id
    @GeneratedValue
    private Integer docId;
    
    private String docTitle;
    
    private String docContent;
    
    private Integer tagId;
    
    private Integer categoryId;
    
    private Integer readSize;

    private Date createTime;
    
    private Date updateTime;
    
    private Integer status;
    
    private Integer groupId;
    
    public Document() {
    }
    
}
