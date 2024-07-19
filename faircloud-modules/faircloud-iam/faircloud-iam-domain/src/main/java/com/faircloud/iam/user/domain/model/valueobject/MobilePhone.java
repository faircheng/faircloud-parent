package com.faircloud.iam.user.domain.model.valueobject;

import com.faircloud.platform.common.enums.StatusCodeEnum;
import com.faircloud.platform.common.exception.BusinessException;
import com.faircloud.platform.common.util.ValidatorUtils;
import lombok.Builder;
import lombok.Value;
import org.apache.commons.lang3.StringUtils;

/**
 * 手机号码
 *
 * @author Fair Cheng
 */
@Value
@Builder
public class MobilePhone {

    private String mobilePhone;

    public MobilePhone(String mobilePhone) {
        if (StringUtils.isNoneBlank(mobilePhone) && !ValidatorUtils.isMobile(mobilePhone)) {
            throw new BusinessException(StatusCodeEnum.A0151);
        }
        this.mobilePhone = mobilePhone;
    }
}
