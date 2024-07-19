package com.faircloud.platform.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 终端的枚举
 *
 * @author Fair Cheng
 */
@RequiredArgsConstructor
public enum TerminalEnum {

    WECHAT_MINI_PROGRAM(1, "微信小程序"),
    WECHAT_WAP(2, "微信公众号"),
    H5(3, "H5 网页"),
    APP(4, "手机 App"),
    ;

    @Getter
    private final int code;

    @Getter
    private final String msg;
}
