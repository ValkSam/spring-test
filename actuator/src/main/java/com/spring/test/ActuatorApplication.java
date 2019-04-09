package com.spring.test;

import com.spring.test.config.ActuatorConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@Import({
        ActuatorConfiguration.class,
})
public class ActuatorApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(ActuatorApplication.class)
                .properties("spring.config.name="
                        + "actuator")
                .build()
                .run(args);
    }

    @GetMapping(value = "/api/{id}")
    public String findingTitleById(@PathVariable("id") String id) {
        return id;
    }

}
