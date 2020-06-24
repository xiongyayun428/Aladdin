package com.xiongyayun.aladdin.service.user.service.impl;

import com.xiongyayun.aladdin.service.user.mapper.UserMapper;
import com.xiongyayun.aladdin.service.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * UserServiceImpl
 *
 * @author: <a href="mailto:xiongyayun428@163.com">Yayun.Xiong</a>
 * @date: 2020/6/24
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public int add() {
        return 0;
    }
}
