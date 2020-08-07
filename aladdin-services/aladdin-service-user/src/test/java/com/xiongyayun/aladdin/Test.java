package com.xiongyayun.aladdin;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Test
 *
 * @author: <a href="mailto:xiongyayun428@163.com">Yayun.Xiong</a>
 * @date: 2020/8/7
 */
public class Test extends TestCase {
    public void testJdk8() {
        String i18nValue = "1测试";
        String[] separator = {" ", ",", "|", ":", "^", ";", "/"};
        String[] i18nValueArray = i18nValue.split("");
        Object val = Arrays.asList(i18nValueArray).stream()
                .filter(v -> Arrays.asList(separator).stream().anyMatch(v::equals))
                .findFirst()
                .orElse(null)
                ;
//                .isPresent()
//                .get();
        System.out.println(val);
        if (val != null) {
            int s = i18nValue.indexOf(String.valueOf(val));
            System.out.println(i18nValue.substring(0, s) + "-" + i18nValue.substring(s + 1));
        } else {
            System.out.println(i18nValue);
        }


    }
}
