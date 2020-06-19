package com.xiongyayun.aladdin.spring.boot.admin.configuration;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * Security配置类，用于配置admin server的安全控制
 *
 * @author: Yayun.Xiong
 * @date 2019/03/03
 */
//@EnableWebSecurity
@Configuration
public class SecurityServerConfig extends WebSecurityConfigurerAdapter {
	private final String adminContextPath;

	public SecurityServerConfig(AdminServerProperties adminServerProperties) {
		this.adminContextPath = adminServerProperties.getContextPath();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 登录成功处理类
		SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
		successHandler.setTargetUrlParameter("redirectTo");
		successHandler.setDefaultTargetUrl(adminContextPath + "/");

		http.authorizeRequests()
				// 静态文件允许访问
				.antMatchers(adminContextPath + "/assets/**").permitAll()
				// 登录页面允许访问
				.antMatchers(adminContextPath + "/login").permitAll()
				// 其他所有请求需要登录
				.anyRequest().authenticated().and()
				// 登录页面配置，用于替换security默认页面
				.formLogin().loginPage(adminContextPath + "/login").successHandler(successHandler).and()
				// 登出页面配置，用于替换security默认页面
				.logout().logoutUrl(adminContextPath + "/logout").and()
				.httpBasic().and()
				// 跨域
				.csrf()
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
				.ignoringAntMatchers(
					"/instances",
					"/actuator/**"
				);
	}

}

// TODO 打开首页报错 Access is denied (user is anonymous); redirecting to authentication entry point