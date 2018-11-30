package com.zsk.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class TagTable implements Serializable{
    @Id
    @GeneratedValue
    private Integer  tagId;
    private String  tagText;
    private Date    createTime;
    
    public TagTable() {
    }
}
