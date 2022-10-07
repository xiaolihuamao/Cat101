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
                .addPathPatterns("/**")  // 拦截所有请求，通过判断token是否合法来决定是否需要登录
                .excludePathPatterns("/user/login", "/user/register", "/**/export", "/**/import", "/file/**"
                      , "/webjars/**", "/v2/**", "/api", "/api-docs", "/api-docs/**")//放行登录注册，导入导出等功能
                .excludePathPatterns( "/**/*.html", "/**/*.js", "/**/*.css", "/**/*.woff", "/**/*.ttf");  // 放行静态文件

    }

    @Bean
    public JwtInterceptor jwtInterceptor() {
        return new JwtInterceptor();
    }

}
