package com.faircloud.platform.audit.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 持久化主键
 *
 * @param <T> 类型
 * @author Fair Cheng
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractPersistable<T> {

    @TableId
    private Long id;
}
