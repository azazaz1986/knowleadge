CREATE TABLE `document` (
  `doc_id` bigint(128) NOT NULL AUTO_INCREMENT COMMENT '文档主键',
  `doc_title` varchar(255) NOT NULL COMMENT '文档标题',
  `doc_content` varchar(255) NOT NULL COMMENT '文档正文',
  `tag_id` int(10) NOT NULL COMMENT '文档标签',
  `category_id` int(10) NOT NULL COMMENT '文档分类',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '文档创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '文档更新时间',
  `read_size` int(20) unsigned zerofill NOT NULL COMMENT '文档阅读数',
  PRIMARY KEY (`doc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4