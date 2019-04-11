package com.spring.test;

import com.spring.test.config.CassandraReactiveConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@Import({
        CassandraReactiveConfiguration.class,
})
public class CassandraApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(CassandraApplication.class)
                .properties("spring.config.name="
                        + "cassandra")
                .build()
                .run(args);
    }

}
