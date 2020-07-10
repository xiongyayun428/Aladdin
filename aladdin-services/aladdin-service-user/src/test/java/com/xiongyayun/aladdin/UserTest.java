package com.xiongyayun.aladdin;

import com.xiongyayun.aladdin.service.user.mapper.UserMapper;
import com.xiongyayun.aladdin.service.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * TestTask
 *
 * @author: Yayun.Xiong
 * @date: 2019/9/17
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void select() {
        List<User> users = userMapper.selectList(null);
        Assert.assertEquals(5, users.size());
        users.forEach(System.out::println);
    }
}
