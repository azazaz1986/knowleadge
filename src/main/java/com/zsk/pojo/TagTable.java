package com.zsk.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class TagTable implements Serializable{
    @Id
    private String  tagId;
    private String  tagText;
    private Date    createTime;
    
    public TagTable() {
    }
}
