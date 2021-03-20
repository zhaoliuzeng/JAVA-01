package com.louie.week;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.louie.week.myannotation.MyCache;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.util.Reflection;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * before 拦截，假如有缓冲就直接返回，无缓冲，直接存缓存返回
 */
@Aspect
@Component
public class MyCacheAspect {

    private static Cache<String, Object> cache = CacheBuilder.newBuilder()
            .expireAfterWrite(10L, TimeUnit.SECONDS)  //写入10分钟后过期
            .maximumSize(50000L)
            .build();


    @Pointcut(value = "execution(* com.louie.week.GatwayController.*())")
    public void point() {
    }

   /* @Before(value = "point()")
    public void before() {
        System.out.println("========>begin klass dong...");
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName);
    }

    @Around(value = "point()")
    public void after(JoinPoint joinPoint, ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("========>after klass dong...");
        System.out.println(joinPoint.getTarget().getClass());

        System.out.println(methodName);
    }*/


    @Around("point()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("========>around begin klass dong");

        String cacheKey = joinPoint.getSignature().toLongString();
        String methodName = joinPoint.getSignature().getName();
        boolean flag = joinPoint.getTarget().getClass().isAnnotationPresent(MyCache.class);
        Method method = Reflection.getMatchingMethod(joinPoint.getTarget().getClass(), methodName, joinPoint.getArgs());
        boolean isExist = method.isAnnotationPresent(MyCache.class);
        Arrays.stream(method.getDeclaredAnnotations()).forEach(item -> {
            System.out.println(item.toString());
        });
        if (isExist) {
            Object cacheResult = cache.getIfPresent(cacheKey);
            if (cacheResult != null) {
              /*  ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                HttpServletResponse response = attributes.getResponse();
                response.getWriter().write(cacheResult.toString());*/
                return cacheResult;
            }
        }
        Object result = joinPoint.proceed();
        cache.put(cacheKey, result);
        return result;
    }
}
