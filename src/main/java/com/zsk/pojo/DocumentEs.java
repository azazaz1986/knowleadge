package com.zsk.pojo;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@Document(indexName = "document" ,type = "docType", shards = 8, replicas = 1)
public class DocumentEs implements Serializable {
    @Id
    private Integer docId;

    private String docTitle;

    private String docContent;

    private Date createTime;

    public DocumentEs() {
    }

}
