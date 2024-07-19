package com.faircloud.platform.common.validator;

import com.faircloud.platform.common.util.ValidatorUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

/**
 * 手机号校验器
 *
 * @author Fair Cheng
 */
public class MobileValidator implements ConstraintValidator<Mobile, String> {

    private boolean required = false;

    @Override
    public void initialize(Mobile constraintAnnotation) {
        required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (required) {
            return ValidatorUtils.isMobile(value);
        } else {
            if (StringUtils.isEmpty(value)) {
                return true;
            } else {
                return ValidatorUtils.isMobile(value);
            }
        }
    }
}
