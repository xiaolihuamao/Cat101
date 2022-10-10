package com.example.cat101.config;

import com.example.cat101.config.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor())
                .addPathPatterns("/**")  // ������������ͨ���ж�token�Ƿ�Ϸ��������Ƿ���Ҫ��¼
                .excludePathPatterns("/user/login", "/user/register", "/**/export", "/**/import", "/file/**"
                        , "/webjars/**", "/v2/**", "/api", "/api-docs", "/api-docs/**")//���е�¼ע�ᣬ���뵼���ȹ���
                .excludePathPatterns("/**/*.html", "/**/*.js", "/**/*.css", "/**/*.woff", "/**/*.ttf");  // ���о�̬�ļ�

    }

    @Bean
    public JwtInterceptor jwtInterceptor() {
        return new JwtInterceptor();
    }

}
