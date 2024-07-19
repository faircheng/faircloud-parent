package com.faircloud.iam.user.infrastructure.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.faircloud.iam.user.infrastructure.persistence.po.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户Mapper接口
 *
 * @author Fair Cheng
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}