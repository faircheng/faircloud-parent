package com.faircloud.platform.common.util;

/**
 * 上下文获取
 *
 * @author Felix Cheng
 */
public class SecurityUtils {

    private static final ThreadLocal<Long> THREAD_LOCAL_USER = new ThreadLocal<>();

    public static void setUserId(Long userId) {
        THREAD_LOCAL_USER.set(userId);
    }

    public static Long getUserId() {
        return THREAD_LOCAL_USER.get();
    }

    public static void clear() {
        THREAD_LOCAL_USER.remove();
    }
}
