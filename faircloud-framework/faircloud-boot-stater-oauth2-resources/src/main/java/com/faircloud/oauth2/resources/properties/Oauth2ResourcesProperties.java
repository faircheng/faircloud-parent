package com.faircloud.oauth2.resources.properties;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;

/**
 * oauth2 resources properties config
 *
 * @author Fair Cheng
 */
@ConfigurationProperties(prefix = "faircloud.oauth2.resources")
public class Oauth2ResourcesProperties implements InitializingBean {

    @Getter
    private String scopeName;

    @Getter
    private List<String> whitelist;

    @Override
    public void afterPropertiesSet() throws Exception {
        validate();
    }

    public void validate() {

    }
}
