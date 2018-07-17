package com.test.base;

import com.demo.config.AopConfig;
import com.demo.config.MybatisConfig;
import com.demo.config.RedisConfig;
import com.demo.config.WebConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        WebConfig.class,
        MybatisConfig.class,
        RedisConfig.class,
        AopConfig.class
})
public class BaseJunitTest {
}
