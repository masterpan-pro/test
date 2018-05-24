package com.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;

@Slf4j
public class ApplicationStartListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Environment env = contextRefreshedEvent.getApplicationContext().getEnvironment();
        log.info("Startup Success!-->[http://localhost:8088/webjar]");
    }
}
