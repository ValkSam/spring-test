package com.spring.test.config;

import com.datastax.driver.core.PlainTextAuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractClusterConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraCqlSessionFactoryBean;

@Configuration
@EnableConfigurationProperties(CassandraProperties.class)
@ConditionalOnProperty(value = "cassandra.config", havingValue = "reactive")
public class CassandraReactiveConfiguration extends AbstractClusterConfiguration {

    private CassandraProperties cassandraProperties;

    @Autowired
    public CassandraReactiveConfiguration(CassandraProperties cassandraProperties) {
        this.cassandraProperties = cassandraProperties;
    }

    @Bean
    public CassandraClusterFactoryBean cluster() {

        CassandraClusterFactoryBean cluster = super.cluster();
        cluster.setJmxReportingEnabled(false);
        PlainTextAuthProvider sap = new PlainTextAuthProvider(
                cassandraProperties.getUsername(),
                cassandraProperties.getPassword());
        cluster.setContactPoints(cassandraProperties.getUrl());
        cluster.setPort(cassandraProperties.getPort());
        cluster.setAuthProvider(sap);

        return cluster;
    }

    @Bean
    public CassandraCqlSessionFactoryBean session() {

        CassandraCqlSessionFactoryBean session = new CassandraCqlSessionFactoryBean();
        session.setCluster(cluster().getObject());
        session.setKeyspaceName(cassandraProperties.getKeyspaceName());

        return session;
    }

}
