package com.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类，用于管理ContextLoadListener创建的上下文的bean
 */
@Configuration
@ComponentScan({"com.demo.config", "com.demo.dao", "com.demo.service"})
public class RootConfig {
}
