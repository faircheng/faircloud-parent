package com.faircloud.platform.upms.user.interfaces.fallback;

import com.faircloud.platform.common.dto.ResponseDTO;
import com.faircloud.platform.upms.user.client.UserClient;
import com.faircloud.platform.upms.user.dto.UserAddDTO;
import com.faircloud.platform.upms.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 触发服务降级时会调用相应的方法
 * @author Fair Cheng
 */
@Slf4j
@Component
public class UserFeignClientFallback implements FallbackFactory<UserClient> {

    @Override
    public UserClient create(Throwable cause) {
        log.info("client fallback error");
        return new UserClient() {
            @Override
            public ResponseDTO<UserVO> getUserByUserCode(String userCode) {
                return ResponseDTO.fail();
            }

            @Override
            public ResponseDTO insert(UserAddDTO dto) {
                return ResponseDTO.fail();
            }
        };
    }
}
