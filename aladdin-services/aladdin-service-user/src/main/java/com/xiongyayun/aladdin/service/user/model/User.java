package com.xiongyayun.aladdin.service.user.model;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Size;

@ApiModel("用户基础信息表")
@Table(name = "`user`")
@TableName(value = "user", schema = "athena")
public class User implements Serializable {
    /**
     * 用户主键ID
     * 注意：selectById方法默认使用的主键名是id,数据库表中如果主键id名称不一样需要手动指定,使用@TableId注解标记主键id为user_id
     */
    @TableId("user_id")
    @Column(name = "`user_id`")
    @ApiModelProperty("用户主键ID")
    private Long userId;

    /**
     * 用户名
     */
    @Column(name = "`user_name`")
    @ApiModelProperty("用户名")
    @TableField(condition = SqlCondition.LIKE_RIGHT)
    private String userName;

    /**
     * 真实姓名
     */
    @Column(name = "`real_name`")
    @ApiModelProperty("真实姓名")
    @Size(min = 2, max = 20, message = "用户名长度必须为2-20个字符")
    private String realName;

    /**
     * 昵称
     */
    @Column(name = "`nick_name`")
    @ApiModelProperty("昵称")
    private String nickName;

    /**
     * 限制登录的IP地址
     */
    @Column(name = "`access_ip`")
    @ApiModelProperty("限制登录的IP地址")
    private String accessIp;

    /**
     * 限制登录的MAC地址
     */
    @Column(name = "`access_mac`")
    @ApiModelProperty("限制登录的MAC地址")
    private String accessMac;

    /**
     * 状态
     */
    @Column(name = "`status`")
    @ApiModelProperty("状态")
    @TableField(value = "`status`", fill = FieldFill.INSERT)
    private Integer status;

    /**
     * 最近登录的IP地址
     */
    @Column(name = "`last_visit_ip`")
    @ApiModelProperty("最近登录的IP地址")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String lastVisitIp;

    /**
     * 最近登录的时间
     */
    @Column(name = "`last_visit_date`")
    @ApiModelProperty("最近登录的时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date lastVisitDate;

    /**
     * 访问次数
     */
    @Column(name = "`visit_count`")
    @ApiModelProperty("访问次数")
    private Integer visitCount;

    /**
     * 有效期限
     */
    @Column(name = "`visit_date`")
    @ApiModelProperty("有效期限")
    private Date visitDate;

    /**
     * 登录密码错误次数
     */
    @Column(name = "`error_times`")
    @ApiModelProperty("登录密码错误次数")
    private Integer errorTimes;

    /**
     * 是否允许删除(0: false，1: true)
     */
    @Column(name = "`allow_delete`")
    @ApiModelProperty("是否允许删除(0: false，1: true)")
    private Boolean allowDelete;

    /**
     * 创建用户
     */
    @Column(name = "`create_user`")
    @ApiModelProperty("创建用户")
    @TableField(fill = FieldFill.INSERT)
    private String createUser;

    /**
     * 创建时间
     */
    @Column(name = "`create_time`")
    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 最后更新用户
     */
    @Column(name = "`last_update_user`")
    @ApiModelProperty("最后更新用户")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String lastUpdateUser;

    /**
     * 最后更新时间
     */
    @Column(name = "`last_update_time`")
    @ApiModelProperty("最后更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date lastUpdateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取用户主键ID
     *
     * @return user_id - 用户主键ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户主键ID
     *
     * @param userId 用户主键ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取真实姓名
     *
     * @return real_name - 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置真实姓名
     *
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 获取昵称
     *
     * @return nick_name - 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置昵称
     *
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取限制登录的IP地址
     *
     * @return access_ip - 限制登录的IP地址
     */
    public String getAccessIp() {
        return accessIp;
    }

    /**
     * 设置限制登录的IP地址
     *
     * @param accessIp 限制登录的IP地址
     */
    public void setAccessIp(String accessIp) {
        this.accessIp = accessIp;
    }

    /**
     * 获取限制登录的MAC地址
     *
     * @return access_mac - 限制登录的MAC地址
     */
    public String getAccessMac() {
        return accessMac;
    }

    /**
     * 设置限制登录的MAC地址
     *
     * @param accessMac 限制登录的MAC地址
     */
    public void setAccessMac(String accessMac) {
        this.accessMac = accessMac;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取最近登录的IP地址
     *
     * @return last_visit_ip - 最近登录的IP地址
     */
    public String getLastVisitIp() {
        return lastVisitIp;
    }

    /**
     * 设置最近登录的IP地址
     *
     * @param lastVisitIp 最近登录的IP地址
     */
    public void setLastVisitIp(String lastVisitIp) {
        this.lastVisitIp = lastVisitIp;
    }

    /**
     * 获取最近登录的时间
     *
     * @return last_visit_date - 最近登录的时间
     */
    public Date getLastVisitDate() {
        return lastVisitDate;
    }

    /**
     * 设置最近登录的时间
     *
     * @param lastVisitDate 最近登录的时间
     */
    public void setLastVisitDate(Date lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }

    /**
     * 获取访问次数
     *
     * @return visit_count - 访问次数
     */
    public Integer getVisitCount() {
        return visitCount;
    }

    /**
     * 设置访问次数
     *
     * @param visitCount 访问次数
     */
    public void setVisitCount(Integer visitCount) {
        this.visitCount = visitCount;
    }

    /**
     * 获取有效期限
     *
     * @return visit_date - 有效期限
     */
    public Date getVisitDate() {
        return visitDate;
    }

    /**
     * 设置有效期限
     *
     * @param visitDate 有效期限
     */
    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    /**
     * 获取登录密码错误次数
     *
     * @return error_times - 登录密码错误次数
     */
    public Integer getErrorTimes() {
        return errorTimes;
    }

    /**
     * 设置登录密码错误次数
     *
     * @param errorTimes 登录密码错误次数
     */
    public void setErrorTimes(Integer errorTimes) {
        this.errorTimes = errorTimes;
    }

    /**
     * 获取是否允许删除(0: false，1: true)
     *
     * @return allow_delete - 是否允许删除(0: false，1: true)
     */
    public Boolean getAllowDelete() {
        return allowDelete;
    }

    /**
     * 设置是否允许删除(0: false，1: true)
     *
     * @param allowDelete 是否允许删除(0: false，1: true)
     */
    public void setAllowDelete(Boolean allowDelete) {
        this.allowDelete = allowDelete;
    }

    /**
     * 获取创建用户
     *
     * @return create_user - 创建用户
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 设置创建用户
     *
     * @param createUser 创建用户
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取最后更新用户
     *
     * @return last_update_user - 最后更新用户
     */
    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    /**
     * 设置最后更新用户
     *
     * @param lastUpdateUser 最后更新用户
     */
    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    /**
     * 获取最后更新时间
     *
     * @return last_update_time - 最后更新时间
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * 设置最后更新时间
     *
     * @param lastUpdateTime 最后更新时间
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
            && (this.getAccessIp() == null ? other.getAccessIp() == null : this.getAccessIp().equals(other.getAccessIp()))
            && (this.getAccessMac() == null ? other.getAccessMac() == null : this.getAccessMac().equals(other.getAccessMac()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getLastVisitIp() == null ? other.getLastVisitIp() == null : this.getLastVisitIp().equals(other.getLastVisitIp()))
            && (this.getLastVisitDate() == null ? other.getLastVisitDate() == null : this.getLastVisitDate().equals(other.getLastVisitDate()))
            && (this.getVisitCount() == null ? other.getVisitCount() == null : this.getVisitCount().equals(other.getVisitCount()))
            && (this.getVisitDate() == null ? other.getVisitDate() == null : this.getVisitDate().equals(other.getVisitDate()))
            && (this.getErrorTimes() == null ? other.getErrorTimes() == null : this.getErrorTimes().equals(other.getErrorTimes()))
            && (this.getAllowDelete() == null ? other.getAllowDelete() == null : this.getAllowDelete().equals(other.getAllowDelete()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastUpdateUser() == null ? other.getLastUpdateUser() == null : this.getLastUpdateUser().equals(other.getLastUpdateUser()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getAccessIp() == null) ? 0 : getAccessIp().hashCode());
        result = prime * result + ((getAccessMac() == null) ? 0 : getAccessMac().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLastVisitIp() == null) ? 0 : getLastVisitIp().hashCode());
        result = prime * result + ((getLastVisitDate() == null) ? 0 : getLastVisitDate().hashCode());
        result = prime * result + ((getVisitCount() == null) ? 0 : getVisitCount().hashCode());
        result = prime * result + ((getVisitDate() == null) ? 0 : getVisitDate().hashCode());
        result = prime * result + ((getErrorTimes() == null) ? 0 : getErrorTimes().hashCode());
        result = prime * result + ((getAllowDelete() == null) ? 0 : getAllowDelete().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastUpdateUser() == null) ? 0 : getLastUpdateUser().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        return result;
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(getClass().getSimpleName());
//        sb.append(" [");
//        sb.append("Hash = ").append(hashCode());
//        sb.append(", userId=").append(userId);
//        sb.append(", userName=").append(userName);
//        sb.append(", realName=").append(realName);
//        sb.append(", nickName=").append(nickName);
//        sb.append(", accessIp=").append(accessIp);
//        sb.append(", accessMac=").append(accessMac);
//        sb.append(", status=").append(status);
//        sb.append(", lastVisitIp=").append(lastVisitIp);
//        sb.append(", lastVisitDate=").append(lastVisitDate);
//        sb.append(", visitCount=").append(visitCount);
//        sb.append(", visitDate=").append(visitDate);
//        sb.append(", errorTimes=").append(errorTimes);
//        sb.append(", allowDelete=").append(allowDelete);
//        sb.append(", createUser=").append(createUser);
//        sb.append(", createTime=").append(createTime);
//        sb.append(", lastUpdateUser=").append(lastUpdateUser);
//        sb.append(", lastUpdateTime=").append(lastUpdateTime);
//        sb.append(", serialVersionUID=").append(serialVersionUID);
//        sb.append("]");
//        return sb.toString();
//    }
}