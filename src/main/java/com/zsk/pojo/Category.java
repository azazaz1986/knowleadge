package com.zsk.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
@Entity
@Data
public class Category implements Serializable {
    @Id
    @GeneratedValue
    @OneToMany
    private Integer categoryId;
    private String categoryText;
    
    public Category() {
    }
}
