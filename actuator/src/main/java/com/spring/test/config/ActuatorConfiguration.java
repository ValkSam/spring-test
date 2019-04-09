package com.spring.test.config;

import com.spring.test.service.ActuatorService;
import org.springframework.context.annotation.Import;

@Import({
        ActuatorService.class,
})
public class ActuatorConfiguration {

}
