package com.zsk.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
public class Category implements Serializable {
    @Id
    @GeneratedValue
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "document",joinColumns = @JoinColumn(name = "doc_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "category_id" ,referencedColumnName = "id"))
    private Integer categoryId;
    private String categoryText;
    
    public Category() {
    }
}
