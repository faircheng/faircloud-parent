package com.faircloud.platform.common.enums;

/**
 * 状态码的接口，所有状态码都需要实现它
 *
 * @author Felix Cheng
 */
public interface StatusCode {

    /**
     * 编码
     *
     * @return 编码
     */
    public String getCode();

    /**
     * 错误详情
     *
     * @return 详情
     */
    public String getMsg();
}
