package com.zsk.dto;

import com.zsk.pojo.Category;
import lombok.Data;
import java.io.Serializable;

@Data
public class SaveDocumentDTO implements Serializable {

    private String docTitle;

    private String docContent;

    private String tagName;

    private Integer category;

    private Integer groupId;
}
