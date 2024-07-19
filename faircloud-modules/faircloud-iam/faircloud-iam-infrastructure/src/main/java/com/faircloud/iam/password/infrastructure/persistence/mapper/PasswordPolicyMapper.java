package com.faircloud.iam.password.infrastructure.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.faircloud.iam.password.infrastructure.persistence.po.PasswordPolicy;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户密码强度等策略信息 Mapper接口
 *
 * @author Fair Cheng
 */
@Mapper
public interface PasswordPolicyMapper extends BaseMapper<PasswordPolicy> {

}
