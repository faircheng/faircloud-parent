package com.faircloud.platform.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Boolean的枚举
 *
 * @author Fair Cheng
 */
@RequiredArgsConstructor
public enum BooleanEnum {

    TRUE(1, "true"),
    FALSE(0, "false");

    @Getter
    private final int code;

    @Getter
    private final String msg;
}
