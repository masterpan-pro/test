package com.demo;

import com.demo.config.RootConfig;
import com.demo.config.WebConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 应用启动入口和各类配置
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    private final static Logger logger = LoggerFactory.getLogger(WebAppInitializer.class);

    @Override
    protected Class<?>[] getRootConfigClasses() {
        logger.info("------root配置类初始化------");
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        logger.info("------web配置类初始化------");
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        logger.info("------映射根路径初始化------");
        return new String[]{"/"};
    }
}
