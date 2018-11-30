package com.zsk.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
@Data
public class Category implements Serializable {
    @Id
    @GeneratedValue
    private Integer categoryId;
    private String categoryText;
    
    public Category() {
    }
}
