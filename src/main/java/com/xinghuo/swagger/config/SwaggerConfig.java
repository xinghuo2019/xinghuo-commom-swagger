package com.xinghuo.swagger.config;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xinghuo.swagger.properties.XhSwaggerProperties;

import springfox.documentation.builders.ApiInfoBuilder;
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
/**
 * 
 * @类功能说明：    Swagger配置类
 * @作者：胡佛传
 * @创建时间：2019年1月3日 下午7:00:30  
 * @版本：V1.0
 */
@Configuration
@EnableSwagger2
@EnableConfigurationProperties(XhSwaggerProperties.class)
public class SwaggerConfig {
	private static final Logger logger = LoggerFactory.getLogger(SwaggerConfig.class);
	@Autowired
	private XhSwaggerProperties xhSwaggerProperties;
	
	/*
	 * swagger注解

		swagger通过注解表明该接口会生成文档，包括接口名、请求方法、参数、返回信息的等等。
		
		@Api：修饰整个类，描述Controller的作用
		@ApiOperation：描述一个类的一个方法，或者说一个接口
		@ApiParam：单个参数描述
		@ApiModel：用对象来接收参数
		@ApiProperty：用对象接收参数时，描述对象的一个字段
		@ApiResponse：HTTP响应其中1个描述
		@ApiResponses：HTTP响应整体描述
		@ApiIgnore：使用该注解忽略这个API
		@ApiError ：发生错误返回的信息
		@ApiImplicitParam：一个请求参数
		@ApiImplicitParams：多个请求参数
	 */
	@Bean
	public Docket createRestApi() {
		logger.info("Swagger配置初始化");
		logger.info("Swagger扫描路径 {}",xhSwaggerProperties.getBasePackage());
		ParameterBuilder param = new ParameterBuilder();
		List<Parameter> pars = new ArrayList<Parameter>();
		param.name("requestType").description("请求类型").modelRef(new ModelRef("string")).parameterType("header").required(false).build();

		ParameterBuilder param2 = new ParameterBuilder();
		param2.name("serviceID").description("服务ID或者应用ID").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
		pars.add(param.build());
		pars.add(param2.build());

		Docket docket = new Docket(DocumentationType.SWAGGER_2)
		.apiInfo(getApiInfo())
		.enable(true)
		.select()
		.apis(RequestHandlerSelectors.basePackage(xhSwaggerProperties.getBasePackage()))
		.paths(PathSelectors.any())
		.build()
		.pathMapping("/")
		.globalOperationParameters(pars);
		return docket;
	}

	private ApiInfo getApiInfo() {
		logger.info("{}",xhSwaggerProperties.getTitle());
		logger.info("{}",xhSwaggerProperties.getDescription());
		logger.info("{}",xhSwaggerProperties.getDeveloperName());
		ApiInfo apiInfo = new ApiInfoBuilder().title(xhSwaggerProperties.getTitle()).description(xhSwaggerProperties.getDescription()).contact(new Contact(xhSwaggerProperties.getDeveloperName(), "", xhSwaggerProperties.getEmali())).version("1.0.0").build();
		return apiInfo;
	}

}
