package com.xiongyayun.aladdin.service.user.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.function.Supplier;

/**
 * MyBatiaPlusMetaObjectHandler
 *
 * @author: <a href="mailto:xiongyayun428@163.com">Yayun.Xiong</a>
 * @date: 2020/8/5
 */
@Component
public class MyBatisPlusMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.fill(metaObject, "createUser", "admin");
        this.fill(metaObject, "status", "1");
        this.fill(metaObject, "createTime", () -> metaObject.getSetterType("createTime"));
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.fill(metaObject, "lastUpdateUser", "admin");
        this.fill(metaObject, "lastUpdateTime", () -> metaObject.getSetterType("lastUpdateTime"));
    }

    private void fill(MetaObject metaObject, String fieldName, Object fieldVal) {
        this.fill(metaObject, fieldName, () -> fieldVal);
    }

    private void fill(MetaObject metaObject, String fieldName, Supplier<Object> valueSupplier) {
        if (!metaObject.hasGetter(fieldName)) {
            return;
        }
        Object fieldVal = metaObject.getValue(fieldName);
        if (fieldVal == null && metaObject.hasSetter(fieldName) && valueSupplier != null) {
            setFieldValByName(fieldName, valueSupplier.get(), metaObject);
        }
    }

    private Object getDateValue(Class<?> setterType) {
        if (Date.class.equals(setterType)) {
            return new Date();
        } else if (LocalDateTime.class.equals(setterType)) {
            return LocalDateTime.now();
        }
        return null;
    }
}
