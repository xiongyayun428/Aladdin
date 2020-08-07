package com.xiongyayun.aladdin.service.user;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import springfox.documentation.oas.annotations.EnableOpenApi;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * UserApplication
 *
 * @author Yayun.Xiong
 * @date 2020/6/14
 */
@EnableOpenApi
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.xiongyayun.aladdin")
@MapperScan("com.xiongyayun.aladdin.service.user.mapper")
@ComponentScan(basePackages = { "com.xiongyayun" })
public class UserApplication {

    public static void main(String[] args) throws UnknownHostException {
        Logger log = LoggerFactory.getLogger(UserApplication.class);
        ConfigurableApplicationContext context = SpringApplication.run(UserApplication.class, args);
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String pid = name.split("@")[0];
        Environment env = context.getEnvironment();
        String port = env.getProperty("server.port"), contextPath = env.getProperty("server.servlet.context-path", "");
        log.info("\n--------------------------------------------------------------------------------------------------------------------\n\t" +
                        "Application '{}' is running! Pid: {}, Access URLs:\n\t" +
                        "Local: \t\thttp://localhost:{}{}\n\t" +
                        "External: \thttp://{}:{}{}" +
                        "\n--------------------------------------------------------------------------------------------------------------------",
                env.getProperty("spring.application.name", context.getId()),
                pid,
                port,
                contextPath,
                InetAddress.getLocalHost().getHostAddress(),
                port,
                contextPath
        );
    }
}
