package com.qcby.springboottest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrossConfig implements WebMvcConfigurer {


    @Override
    public void addCorsMappings(CorsRegistry registry) {
         //允许所有路径形式访问
         registry.addMapping("/**")
                 //允许跨域访问的域名
                 .allowedOriginPatterns("*")
                 //是否允许cookie
                 .allowCredentials(true)
                 //允许跨域请求的方式
                 .allowedMethods("GET","POST")
                 .allowedHeaders("*")
                 //允许跨域的时间
                 .maxAge(3000);
    }
}
