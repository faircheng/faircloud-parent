package com.faircloud.platform.mybatis.toolkit;

import java.util.Map;
import java.util.Optional;

import com.faircloud.platform.common.module.PageQuery;

/**
 * 参数工具类
 *
 * @author Felix Cheng
 */
public class ParameterUtils {

    private ParameterUtils() {

    }

    /**
     * 查找分页参数
     *
     * @param parameterObject 参数对象
     * @return 分页参数
     */
    public static Optional<PageQuery> findPage(Object parameterObject) {
        if (parameterObject != null) {
            if (parameterObject instanceof Map) {
                Map<?, ?> parameterMap = (Map<?, ?>)parameterObject;
                for (Map.Entry entry : parameterMap.entrySet()) {
                    if (entry.getValue() != null && entry.getValue() instanceof PageQuery) {
                        return Optional.of((PageQuery)entry.getValue());
                    }
                }
            } else if (parameterObject instanceof PageQuery) {
                return Optional.of((PageQuery)parameterObject);
            }
        }
        return Optional.empty();
    }
}
