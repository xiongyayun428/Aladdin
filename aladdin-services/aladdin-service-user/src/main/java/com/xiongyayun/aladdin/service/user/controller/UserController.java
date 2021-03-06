package com.xiongyayun.aladdin.service.user.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiongyayun.aladdin.service.user.feign.FileService;
import com.xiongyayun.aladdin.service.user.model.User;
import com.xiongyayun.aladdin.service.user.service.Message;
import com.xiongyayun.aladdin.service.user.service.UserService;
import com.xiongyayun.aladdin.service.user.vo.UserVo;
import com.xiongyayun.athena.core.annotation.Logger;
import com.xiongyayun.athena.core.exception.AthenaRuntimeException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * UserController
 *
 * @author Yayun.Xiong
 * @date 2020/6/14
 */
@Slf4j
@RestController
@Api(tags = {"UserController", "用户"})
@RequestMapping("/user")
@RefreshScope
public class UserController {
    @Resource
    private FileService fileService;

    @Resource
    private Message message;

    @Value("${server.port}")
    private String serverPort;
    @Resource
    private UserService userService;


    @GetMapping(value = "/get", produces = MediaType.APPLICATION_XML_VALUE)
    @SentinelResource("get")
    public User get() {
        User user = new User();
        user.setUserId(2L);
        user.setUserName("熊大大");
        return user;
    }

    @GetMapping("/download")
//    @SentinelResource("download")
    public String download() {
        return fileService.download("a");
    }

    @GetMapping("/")
    public List<User> home(User user) {
        return userService.selectList(user);
    }

    @GetMapping("/send")
    public String send() {
        return message.send();
    }

    @ApiOperation("新增用户")
    @RequestMapping("/add")
    public void addUser() {
        User user = new User();
        userService.insert(user);
    }

    @ApiOperation("修改用户")
    @Logger("修改用户")
    @PostMapping("/update")
    public void updateUser() {
        throw new AthenaRuntimeException("测试错误");
    }

    @ApiOperation("删除单个用户")
    @GetMapping(value = "/delete/{userId}")
    public void deleteUserById(@ApiParam("用户ID") @PathVariable Long userId) {
        // TODO 判断userId不为空
        User user = new User();
        user.setUserId(userId);
        if (userService.delete(user) > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    @ApiOperation("删除多个用户")
    @PostMapping(value = "/delete/batch")
    public void deleteBatch(@RequestParam("userIds") List<Long> userIds) {

    }

//    @ApiOperation("查询用户明细")
//    @GetMapping(value = "/{userId}")
//    public UserVo getUserById(@ApiParam("用户ID") @PathVariable Long userId) {
//        User user = userService.selectById(userId);
//        UserVo userVo = new UserVo();
//        if (user != null) {
//            BeanUtils.copyProperties(user, userVo);
//        }
//        return userVo;
//    }

    @Logger(value = "根据用户ID查询用户明细", save = true)
    @ApiOperation("根据用户ID查询用户明细")
    @RequestMapping(value = "/id/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserById(@ApiParam("用户ID") @PathVariable Long userId) {
        return userService.selectById(userId);
    }

    @Logger(value = "查询所有用户明细", save = true)
    @ApiOperation("查询所有用户明细")
    @GetMapping(value = "/list")
    public List<User> list(User user) {
        return userService.selectList(user);
    }

    @Logger(value = "分页查询用户明细", save = true)
    @ApiOperation("分页查询用户明细")
    @GetMapping(value = "/page")
    public IPage<User> page(User user) {
        return userService.selectPage(user, 1, 10);
    }
}
