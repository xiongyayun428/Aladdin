package com.xiongyayun.aladdin.service.id;

import com.sankuai.inf.leaf.plugin.annotation.EnableLeafServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * UserApplication
 *
 * @author Yayun.Xiong
 * @date 2020/6/14
 */
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@EnableLeafServer
public class LeafApplication {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext context = SpringApplication.run(LeafApplication.class, args);
        Environment env = context.getEnvironment();
        String port = env.getProperty("server.port"), contextPath = env.getProperty("server.servlet.context-path", "");
        log.info("\n--------------------------------------------------------------------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\thttp://localhost:{}{}\n\t" +
                        "External: \thttp://{}:{}{}" +
                        "\n--------------------------------------------------------------------------------------------------------------------",
                env.getProperty("spring.application.name", context.getId()),
                port,
                contextPath,
                InetAddress.getLocalHost().getHostAddress(),
                port,
                contextPath
        );
    }
}
