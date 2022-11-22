package com.qcby.springboottest.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
    @Bean
    public Docket createRestAPi() {
        // 构造函数传入初始化规范，这是swagger2规范
        return new Docket(DocumentationType.SWAGGER_2)
                // apiInfo：添加api的详情信息，参数为ApiInfo类型的参数，这个参数包含了基本描述信息：比如标题、描述、版本之类的，开发中一般都是自定义这些信息
                .apiInfo(apiInfo())
                // select、apis、paths、build 这四个是一组的，组合使用才能返回一个Docket实例对象，其中apis和paths是可选的。
                .select()
                // apis:添加过滤条件。RequestHandlerSelectors中有很多过滤方式；RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)：加了ApiOperation注解的类，生成接口文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                // paths：控制那些路径的api会被显示出来。
                .paths(PathSelectors.any())
                .build()
                // 是否开启swagger 如果是false，浏览器将无法访问，默认是true
                .enable(true)
                ;
    }

    /**
     * 页面信息展示
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 标题内容
                .title("API文档")
                // 描述内容
                .description("接口文档详情信息")
                // 版本
                .version("1.0")
                // 联系人信息
                .contact(new Contact("", "", ""))
                // 许可
                .license("")
                // 许可链接
                .licenseUrl("")
                .build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/**").addResourceLocations(
                "classpath:/static/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations(
                "classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations(
                "classpath:/META-INF/resources/webjars/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

}
