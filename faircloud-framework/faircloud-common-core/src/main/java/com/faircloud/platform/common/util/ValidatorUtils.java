package com.faircloud.platform.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * 校验器 工具类
 *
 * @author Felix Cheng
 */
public class ValidatorUtils {

    /**
     * 正则
     */
    private static final Pattern mobile_pattern = Pattern.compile("1\\d{10}");

    /**
     * 实现
     * @param str 字符串
     * @return boolean
     */
    public static Boolean isMobile(String str){
        if(StringUtils.isEmpty(str)){
            return false;
        }
        //验证正则表达式，并返回ture/false
        Matcher m  = mobile_pattern.matcher(str);
        return m.matches();
    }
}
