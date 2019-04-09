package com.spring.test.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class CustomTwoHealthIndicator implements HealthIndicator {

    private final AtomicBoolean switcher = new AtomicBoolean(true);

    @Override
    public Health health() {
        int errorCode = performHealthCheck();
        if (errorCode != 0) {
            return Health.down().withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }

    private int performHealthCheck() {
        switcher.set(!switcher.get());
        return switcher.get() ? 1 : 0;
    }

}
