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

    /**
     * 根据用户ID修改用户
     * @param user
     * @return
     */
    int updateById(User user);
    /**
     * 修改用户
     * @param user
     * @return
     */
    int update(User user);

    /**
     * 根据用户ID删除用户
     * @param userId
     * @return
     */
    int deleteById(Long userId);

    /**
     * 根据用户所有字段匹配删除用户
     * @param user
     * @return
     */
    int delete(User user);

    User selectByPrimaryKey(Long userId);

    List<User> selectUser(User user, int pageNum, int pageSize);
}
