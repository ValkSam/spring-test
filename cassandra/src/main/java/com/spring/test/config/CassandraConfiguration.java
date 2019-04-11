package com.spring.test.config;

import com.datastax.driver.core.AuthProvider;
import com.datastax.driver.core.PlainTextAuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.lang.Nullable;

@Configuration
@EnableConfigurationProperties(CassandraProperties.class)
@ConditionalOnProperty(value = "cassandra.config", havingValue = "abstract")
public class CassandraConfiguration extends AbstractCassandraConfiguration {

    private CassandraProperties cassandraProperties;

    @Autowired
    public CassandraConfiguration(CassandraProperties cassandraProperties) {
        this.cassandraProperties = cassandraProperties;
    }

    @Bean
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = super.cluster();
        cluster.setJmxReportingEnabled(false);
        return cluster;
    }

    @Override
    protected String getContactPoints() {
        return cassandraProperties.getUrl();
    }

    @Override
    protected int getPort() {
        return cassandraProperties.getPort();
    }

    @Nullable
    @Override
    protected AuthProvider getAuthProvider() {
        return new PlainTextAuthProvider(
                cassandraProperties.getUsername(),
                cassandraProperties.getPassword());
    }

    @Override
    protected String getKeyspaceName() {
        return cassandraProperties.getKeyspaceName();
    }

}
