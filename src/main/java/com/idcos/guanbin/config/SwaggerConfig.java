package com.idcos.guanbin.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

/**
 * Created by guanbin on 2017/9/12.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {

        Parameter parameterAccessToken =
                new ParameterBuilder().name("access-token").description("Access token identifier")
                        .modelRef(new ModelRef("string")).parameterType("header").required(false).build();


        Docket docket = new Docket(DocumentationType.SWAGGER_2).groupName("BaseApi").apiInfo(getApiInfo())
                .select()
                .apis(Predicates.or(RequestHandlerSelectors.basePackage("com.idcos.cloudres.web.controller"), RequestHandlerSelectors.basePackage("com.idcos.cloudres.export"))) // 对所有api进行监控
                .paths(PathSelectors.any()) // 对所有路径进行监控
                .build();
        docket.globalOperationParameters(Arrays.asList(new Parameter[]{parameterAccessToken}) );
        return docket;
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo("测试平台API", "测试平台API汇总", "1.0", "http://dcosgf.idcos.net",
                new Contact("杭州云霁科技有限公司", "http://www.idcos.com", "gaunbin@idcos.com"), "商业版本", "");
    }
}
