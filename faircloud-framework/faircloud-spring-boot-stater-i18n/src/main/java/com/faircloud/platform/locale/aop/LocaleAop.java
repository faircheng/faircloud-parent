package com.faircloud.platform.locale.aop;

import com.faircloud.platform.common.module.Response;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.i18n.LocaleContextHolder;

@Aspect
@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
@RequiredArgsConstructor
public class LocaleAop {

    private final MessageSource messageSource;

    /**
     * 声明一个切入点，范围为返回Response的方法
     * 注：作为切入点签名的方法必须返回void类型
     */
    @Pointcut("execution(public * com.faircloud..web..*.*(..))")
    private void localeAop() {

    }

    @AfterReturning(value = "localeAop()", returning = "result")
    public void afterReturningPublish(Object result) {
        if (result != null && result instanceof Response<?>) {
            Response response = (Response) result;
            if (StringUtils.isNoneBlank(response.getMsg())) {
                response.setMsg(messageSource.getMessage(response.getMsg(), null, response.getMsg(), LocaleContextHolder.getLocale()));
            }
        }
    }
}
