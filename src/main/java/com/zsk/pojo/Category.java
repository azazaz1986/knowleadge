package com.zsk.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
public class Category implements Serializable {
    @Id
    @GeneratedValue
    private Integer categoryId;
    
    @NotEmpty(message = "类别名称不能为空")
    @Size(min=2, max=30)
    @Column(nullable = false) // 映射为字段，值不能为空
    private String categoryText;
    @JsonIgnore
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Document> documents;
    
    @Column(name = "parent_id")
    @Size(min = 2,max = 11)
    private Integer parentId;
    
    @Column(name = "doc_type")
//    @Size(min = 2,max = 5)
    private Integer docType;
    
//    @Size(min = 2,max = 5)
    @Column(name = "watch_status")
    private Integer watchStatus;

    
    
    public Category() {
    }
}
