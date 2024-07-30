package com.faircloud.platform.locale;

import com.faircloud.platform.locale.aop.LocaleAop;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.HibernateValidator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * 自动装配
 *
 * @author Fair Cheng
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class LocaleAutoConfiguration {

    private final MessageSource messageSource;

    @Bean
    @ConditionalOnMissingBean(LocaleAop.class)
    public LocaleAop localeAop() {
        return new LocaleAop(messageSource);
    }

    /**
     * Configures the validator factory bean with the provided message source.
     *
     * @return the configured validator factory bean
     */
    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
        validatorFactoryBean.setProviderClass(HibernateValidator.class);
        validatorFactoryBean.setValidationMessageSource(messageSource);
        return validatorFactoryBean;
    }
}
