package com.faircloud.platform.audit;

import com.faircloud.platform.audit.handler.AuditMetaObjectHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 审计starter
 * @author Felix Cheng
 */
@Configuration
public class AuditAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(AuditMetaObjectHandler.class)
    public AuditMetaObjectHandler auditMetaObjectHandler() {
        return new AuditMetaObjectHandler();
    }

}
