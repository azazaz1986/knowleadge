package com.zsk.config;


import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;


@Configuration
@EnableElasticsearchRepositories(basePackages = "com.zsk.dao")
@Component
public class ElasticConfig {
  /*  @Resource
    private Environment environment;

    private TransportClient client;
    private TransportAddress address;
    @Bean
    public Client client() {



        try {
            InetSocketTransportAddress node = new InetSocketTransportAddress(
                    InetAddress.getByName("127.0.0.1"),
                    9300
            );
            Settings settings = Settings.builder()
                    .put("cluster.name", "wali")
                    .build();
            client.addTransportAddress(node);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return client;
    }
    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(client());
    }*/
}