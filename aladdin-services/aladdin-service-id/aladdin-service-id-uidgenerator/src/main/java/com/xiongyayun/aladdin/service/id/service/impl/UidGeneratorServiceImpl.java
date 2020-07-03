package com.xiongyayun.aladdin.service.id.service.impl;

import com.baidu.fsg.uid.UidGenerator;
import com.baidu.fsg.uid.exception.UidGenerateException;
import com.xiongyayun.aladdin.service.id.service.UidGeneratorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * UidGeneratorServiceImpl
 *
 * @author: <a href="mailto:xiongyayun428@163.com">Yayun.Xiong</a>
 * @date: 2020/6/28
 */
@Service
public class UidGeneratorServiceImpl implements UidGeneratorService {
    @Resource
    private UidGenerator uidGenerator;

    @Override
    public long getUID() throws UidGenerateException {
        return uidGenerator.getUID();
    }

    @Override
    public String parseUID(long uid) {
        return uidGenerator.parseUID(uid);
    }
}
