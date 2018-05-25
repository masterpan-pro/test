package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

/**
 * 配置类，用于定义DispatcherServlet上下文的bean
 * 参考：
 * https://www.luckyryan.com/2013/02/07/migrate-spring-mvc-servlet-xml-to-java-config/
 */
@Configuration
@EnableWebMvc
@Import({MybatisConfig.class, RedisConfig.class})
@ComponentScan({"com.demo.controller", "com.demo.service", "com.demo.dao"})
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public ApplicationStartListener applicationStartListener() {
        return new ApplicationStartListener();
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver tvr = new ThymeleafViewResolver();
        SpringTemplateEngine ste = new SpringTemplateEngine();
        ServletContextTemplateResolver sctr = new ServletContextTemplateResolver();
        sctr.setPrefix("/WEB-INF/views/");
        sctr.setSuffix(".html");
        sctr.setCacheable(false);
        sctr.setCharacterEncoding("UTF-8");
        sctr.setTemplateMode("HTML5");
        ste.setTemplateResolver(sctr);
        tvr.setTemplateEngine(ste);
        tvr.setCharacterEncoding("UTF-8");
        return tvr;
    }

    /**
     * 转换JSON
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();
        List<MediaType> mediaTypes = Arrays.asList(
                new MediaType("text", "plain", Charset.forName("UTF-8")),
                new MediaType("application", "json", Charset.forName("UTF-8")));
        jsonMessageConverter.setSupportedMediaTypes(mediaTypes);
        converters.add(jsonMessageConverter);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
        registry.addResourceHandler("/favicon.ico").addResourceLocations("/WEB-INF/favicon.ico");
    }
}
