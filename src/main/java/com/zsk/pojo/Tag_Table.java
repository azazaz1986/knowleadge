package com.zsk.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Tag_Table implements Serializable{
    @Id
    private String  tag_ID;
    private String  tag_Text;
    private Date    create_Time;
}
