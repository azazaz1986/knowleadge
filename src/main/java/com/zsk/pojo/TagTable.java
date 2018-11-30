package com.zsk.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class TagTable implements Serializable{
    @Id
    @GeneratedValue
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "document",joinColumns = @JoinColumn(name = "doc_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id" ,referencedColumnName = "id"))
    private Integer  tagId;
    private String  tagText;
    private Date    createTime;
    
    public TagTable() {
    }
}
