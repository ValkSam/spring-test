package com.spring.test.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties("cassandra")
public class CassandraProperties {

    private String url;
    private Integer port;
    private String keyspaceName;
    private String username;
    private String password;

}
