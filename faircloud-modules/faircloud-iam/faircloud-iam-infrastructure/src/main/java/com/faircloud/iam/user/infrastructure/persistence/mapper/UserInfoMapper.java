package com.faircloud.iam.user.infrastructure.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.faircloud.iam.user.infrastructure.persistence.po.User;
import com.faircloud.iam.user.infrastructure.persistence.po.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * UserInfoMapper
 * @author Felix Cheng
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}
