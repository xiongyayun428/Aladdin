//package com.xiongyayun.aladdin.spring.cloud.filter;
//
//import io.netty.handler.codec.http.HttpUtil;
//import io.netty.util.CharsetUtil;
//import org.bouncycastle.jcajce.provider.symmetric.AES;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.web.util.UriComponentsBuilder;
//import reactor.core.publisher.Mono;
//import sun.security.util.SecurityConstants;
//
//import javax.crypto.spec.IvParameterSpec;
//import javax.crypto.spec.SecretKeySpec;
//import java.net.URI;
//import java.nio.charset.StandardCharsets;
//import java.util.Map;
//
///**
// * 密码解密工具类
// *
// * @author: <a href="mailto:xiongyayun428@163.com">Yayun.Xiong</a>
// * @date: 2020/6/18
// */
//public class PasswordDecoderFilter extends AbstractGatewayFilterFactory {
//    private static final String PASSWORD = "password";
//    private static final String KEY_ALGORITHM = "AES";
//    @Value("${security.encode.key:1234567812345678}")
//    private String encodeKey;
//
//    private static String decryptAES(String data, String pass) {
//        AES aes = new AES(Mode.CBC, Padding.NoPadding,
//                new SecretKeySpec(pass.getBytes(), KEY_ALGORITHM),
//                new IvParameterSpec(pass.getBytes()));
//        byte[] result = aes.decrypt(Base64.decode(data.getBytes(StandardCharsets.UTF_8)));
//        return new String(result, StandardCharsets.UTF_8);
//    }
//
//    @Override
//    public GatewayFilter apply(Object config) {
//        return (exchange, chain) -> {
//            ServerHttpRequest request = exchange.getRequest();
//
//            // 不是登录请求，直接向下执行
//            if (!StrUtil.containsAnyIgnoreCase(request.getURI().getPath(), SecurityConstants.OAUTH_TOKEN_URL)) {
//                return chain.filter(exchange);
//            }
//
//            URI uri = exchange.getRequest().getURI();
//            String queryParam = uri.getRawQuery();
//            Map<String, String> paramMap = HttpUtil.decodeParamMap(queryParam, CharsetUtil.CHARSET_UTF_8);
//
//            String password = paramMap.get(PASSWORD);
//            if (StrUtil.isNotBlank(password)) {
//                try {
//                    password = decryptAES(password, encodeKey);
//                } catch (Exception e) {
//                    log.error("密码解密失败:{}", password);
//                    return Mono.error(e);
//                }
//                paramMap.put(PASSWORD, password.trim());
//            }
//
//            URI newUri = UriComponentsBuilder.fromUri(uri)
//                    .replaceQuery(HttpUtil.toParams(paramMap))
//                    .build(true)
//                    .toUri();
//
//            ServerHttpRequest newRequest = exchange.getRequest().mutate().uri(newUri).build();
//            return chain.filter(exchange.mutate().request(newRequest).build());
//        };
//    }
//}
