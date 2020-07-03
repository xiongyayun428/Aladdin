package com.xiongyayun.aladdin.service.user.service;

import com.xiongyayun.aladdin.service.user.model.User;

import java.util.List;

/**
 * UserService
 *
 * @author Yayun.Xiong
 * @date 2020/6/14
 */
public interface UserService {

    /**
     * 新增用户
     * @param user
     * @return
     */
    int insert(User user);

    int updateByPrimaryKey(User user);

    int updateByPrimaryKeySelective(User user);

    int delete(User user);

    User selectByPrimaryKey(Long userId);

    List<User> selectUser(User user, int pageNum, int pageSize);
}
