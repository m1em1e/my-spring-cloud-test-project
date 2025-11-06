package org.genntii.handler;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 *
 *
 *
 * @author mkdir
 * @since 2025/11/06 11:38
 */
@Aspect
@Component
public class ParamLoggerHandler {

    private static final Logger log = LoggerFactory.getLogger(ParamLoggerHandler.class);

    // 定义切点，拦截所有Controller中的公共方法
    @Pointcut("execution(public * *(..)) && @within(org.springframework.web.bind.annotation.RestController)")
    public void controllerMethodPointcut() {}

    // 环绕通知，处理日志记录
    @Around("controllerMethodPointcut()")
    public Object handleControllerMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        // 获取请求信息
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = null;
        if (attributes != null) {
            request = attributes.getRequest();
        }

        // 记录入参
        String method = request != null ? request.getMethod() : "UNKNOWN";
        String uri = request != null ? request.getRequestURI() : "UNKNOWN";
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        log.info("发现入参：\n请求方式: {}\n路径：{}，\n方法：{}.{}，\n入参：{}",
                method, uri, className, methodName, args);

        Object result;
        try {
            // 执行目标方法
            result = joinPoint.proceed();

            // 记录出参
            long endTime = System.currentTimeMillis();
            log.info("出参：\n方法：{}，\n时间：{}ms，\n出参:{}",
                    methodName, (endTime - startTime), result);
        } catch (Exception e) {
            long endTime = System.currentTimeMillis();
            log.error("抛出异常：\n方法：{}，\n时间：{}ms，\n异常:{}",
                    methodName, (endTime - startTime), e.getMessage(), e);
            throw e;
        }

        return result;
    }
}
