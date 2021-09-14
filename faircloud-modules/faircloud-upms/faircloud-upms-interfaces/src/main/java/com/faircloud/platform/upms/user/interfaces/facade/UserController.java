package com.faircloud.platform.upms.user.interfaces.facade;

import com.faircloud.platform.common.dto.ResponseDTO;
import com.faircloud.platform.upms.user.client.UserClient;
import com.faircloud.platform.upms.user.dto.UserAddDTO;
import com.faircloud.platform.upms.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器
 * @author Fair Cheng
 */
@Slf4j
@RestController
public class UserController implements UserClient {

    @Override
    public ResponseDTO<UserVO> getUserByUserCode(String userCode) {

        return ResponseDTO.success();
    }

    @Override
    public ResponseDTO insert(UserAddDTO dto) {

        return null;
    }
}
