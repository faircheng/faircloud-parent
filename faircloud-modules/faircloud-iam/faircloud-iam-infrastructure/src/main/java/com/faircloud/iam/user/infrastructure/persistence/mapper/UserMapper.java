package com.faircloud.iam.user.infrastructure.persistence.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.faircloud.iam.user.infrastructure.persistence.po.User;

/**
 * 用户Mapper接口
 *
 * @author Felix Cheng
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 游标查询分页
     * @param page 分页参数
     * @param query 查询参数
     * @return 数据
     */
    Page<User> listUsers(IPage<User> page, User query);
}
