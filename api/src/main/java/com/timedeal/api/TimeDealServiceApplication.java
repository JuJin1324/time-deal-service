package com.timedeal.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class TimeDealServiceApplication {

    private static final Logger log = LoggerFactory.getLogger(TimeDealServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TimeDealServiceApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        log.info("Time-Deal Service API Application has started successfully.");
        // Add any post-startup logic here
    }
}
