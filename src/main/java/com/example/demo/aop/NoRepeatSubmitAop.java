package com.example.demo.aop;
import com.example.demo.annotation.NoRepeatSubmit;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import com.google.common.cache.Cache;
/**
 * @program: Druid
 * @description:
 * @author: ChenYu
 * @create: 2018-09-19 16:49
 **/
@Aspect
@Component
public class NoRepeatSubmitAop {


    @Autowired
    private Cache<String, Integer> cache;


    // @annotation(nrs) 代表是否有NoRepeatSubmit 注解

    @Around("execution(* com.example.demo.controller.*Controller.*(..)) && @annotation(nrs)")
    public Object around(ProceedingJoinPoint pjp, NoRepeatSubmit nrs) {
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            String sessionId = RequestContextHolder.getRequestAttributes().getSessionId();
            HttpServletRequest request = attributes.getRequest();
            String key = sessionId + "-" + request.getServletPath();
            System.out.println(key);
            // 如果缓存中有这个url视为重复提交
            if (cache.getIfPresent(key) == null) {
                System.out.println("没有重复提交，进行业务逻辑");
                Object o = pjp.proceed();
                cache.put(key, 0);
                return o;
            } else {
                System.out.println("重复提交");
                return null;
            }
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("验证重复提交时出现未知异常!");
            return "{\"code\":-889,\"message\":\"验证重复提交时出现未知异常!\"}";
        }

    }



}
