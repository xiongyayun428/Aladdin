package com.xiongyayun.aladdin.service.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    public int updateById(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user, Wrappers.<User>lambdaUpdate()
                .eq(User::getUserId, user.getUserId())
        );
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
    public int deleteById(Long userId) {
        return userMapper.deleteById(userId);
    }

    @Override
    public int delete(User user) {
        return userMapper.delete(Wrappers.lambdaQuery(user));
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

    public List<User> selectList(User user) {
        return userMapper.selectList(Wrappers.lambdaQuery(user));
    }

    public IPage<User> selectPage(User user, int pageNum, int pageSize) {
        Page<User> page = new Page<>(pageNum, pageSize);
        return userMapper.selectPage(page, Wrappers.lambdaQuery(user));
    }
}
