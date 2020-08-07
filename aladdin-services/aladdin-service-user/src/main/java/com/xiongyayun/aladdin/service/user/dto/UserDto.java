package com.xiongyayun.aladdin.service.user.dto;

/**
 * DTO(Data Transfer Object): 用户数据传输对象
 *
 * @author: <a href="mailto:xiongyayun428@163.com">Yayun.Xiong</a>
 * @date: 2020/7/6
 */
public class UserDto {
    /**
     * 用户主键ID
     */
    private Long userId;

    /**
     * 用户名
     */
    private String userName;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
