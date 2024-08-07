package com.faircloud.platform.common.module;

import lombok.Getter;
import lombok.Setter;

/**
 * 排序元素载体
 *
 * @author Felix Cheng
 */
@Getter
@Setter
public class OrderItem extends Query {

    /**
     * 需要进行排序的字段
     */
    private String column;

    /**
     * 是否正序排列，默认 true
     */
    private Boolean asc = true;
}
