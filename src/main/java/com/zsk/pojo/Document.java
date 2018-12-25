package com.zsk.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
// indexName ：索引名字（对应mysql的数据库名字）
//type:类型（对应mysql的表名）
/** 文档实体类
 * @author 夜尽
 * @date 2018/11/29 14:40
 */
@Entity
@Getter
@Setter
@DynamicUpdate
@org.springframework.data.elasticsearch.annotations.Document(indexName = "docs",type = "doc")
public class Document implements Serializable {
    private static final long serialVersionUID = -8033450866659078468L;
    @Id
    @GeneratedValue
    private Integer docId;


    //修改文章人的名称
    private String modifierName;

    //作者名称
    private String authorName;



    @NotEmpty(message = "标题不能为空")
    @Size(min=2, max=50)
    @Column(nullable = false, length = 50) // 映射为字段，值不能为空
    private String docTitle;
    
    @Lob
    @NotEmpty(message = "内容不能为空")
    @Basic(fetch=FetchType.LAZY) // 懒加载
    @Size(min=2)
    @Column(nullable = false) // 映射为字段，值不能为空
    private String docContent;
    
    @Column(name="tag_name",length=100)
    private String tagName;
    
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH},optional = false)
    @JoinColumn(name = "category_id")
    private Category category;
    //阅读量
    @Column(name="readSize")
    private Integer readSize;
    
    @Column(name="create_time") // 映射为字段，值不能为空
    @CreationTimestamp  // 由数据库自动创建时间
    private Date createTime;
    
    @Column(name="update_time") // 映射为字段，值不能为空
    @UpdateTimestamp // 由数据库自动创建时间
    private Date updateTime;
    
    @Column(name="status")
    private Integer status;
    
    @Column(name="group_id")
    private Integer groupId;


    public Document() {
    }
    
}
