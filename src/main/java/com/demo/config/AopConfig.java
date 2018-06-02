package com.demo.config;

import com.demo.annotation.OperationLog;
import com.demo.entity.Log;
import com.demo.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Slf4j
@Aspect
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class AopConfig {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private LogService logService;

    /**
     * 切点
     */
    @Pointcut("execution(* com.demo.controller.*.*(..)) && @annotation(operationLog)")
    public void pointCut(OperationLog operationLog) {
    }

    /**
     * 环绕通知：目标方法执行前后分别执行一些代码，发生异常的时候执行另外一些代码
     */
    @Around(value = "pointCut(operationLog)", argNames = "joinPoint,operationLog")
    public Object logAround(ProceedingJoinPoint joinPoint, OperationLog operationLog) {
        Object result = null;
        long startTime = System.currentTimeMillis();
        Log logEntity = Log.builder()
                .type("info")
                .title(operationLog.description())
                .remoteAddr(request.getRemoteAddr())
                .requestUri(request.getRequestURI())
                .method(request.getMethod())
                .params(request.getParameterMap().toString())
                .operateDate(new Date())
                .build();
        logService.insertSelective(logEntity);
        try {
            // 执行目标方法
            result = joinPoint.proceed();
        } catch (Throwable e) {
            log.info("", e);
            logEntity.setType("error");
            logEntity.setException(e.getMessage());
        } finally {
            logEntity.setTimeout(String.valueOf(System.currentTimeMillis() - startTime).concat("ms"));
            logService.update(logEntity);
        }
        return result;
    }
}
