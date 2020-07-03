package com.xiongyayun.aladdin.service.user.service.impl;

import com.xiongyayun.aladdin.service.user.mapper.UserMapper;
import com.xiongyayun.aladdin.service.user.model.User;
import com.xiongyayun.aladdin.service.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int updateByPrimaryKey(User user) {
        return userMapper.updateById(user);
//        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public int updateByPrimaryKeySelective(User user) {
        return 0;
//        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int delete(User user) {
        return 0;
//        return userMapper.delete(user);
    }

    @Override
    public User selectByPrimaryKey(Long userId) {
        return null;
//        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<User> selectUser(User user, int pageNum, int pageSize) {
        return null;
//        PageHelper.startPage(pageNum, pageSize);
//        return userMapper.select(user);
    }
}
