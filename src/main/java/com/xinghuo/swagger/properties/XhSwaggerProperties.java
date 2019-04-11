package com.xinghuo.swagger.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * 
 * @ClassName: XhSwaggerProperties 
 * @类功能说明：     swagger 属性实体对象
 * @作者：胡佛传
 * @创建时间：2019年2月15日 下午2:03:12  
 * @版本：V1.0
 */
@Component
@ConfigurationProperties(prefix = XhSwaggerProperties.XH_SWAGGER_PREFIX)
//@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true,encoding = "UTF-8")
@Validated
public class XhSwaggerProperties {
	public static final String XH_SWAGGER_PREFIX = "xh.swagger";
	
	@Value("${xh.swagger.basePackage:请配置controller路径}")
	private String basePackage;
	
	@Value("${xh.swagger.title:请配置文档标题}")
	private String title;
	
	@Value("${xh.swagger.description:请配置文档描述}")
	private String description;
	
	@Value("${xh.swagger.emali:请配置作者邮箱}")
	private String emali;
	
	@Value("${xh.swagger.developerName:开发者是谁}")
	private String developerName;
	
	@Value("${xh.swagger.version:请配置版本}")
	private String version;

	public String getBasePackage() {
		return basePackage;
	}

	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmali() {
		return emali;
	}

	public void setEmali(String emali) {
		this.emali = emali;
	}

	public String getDeveloperName() {
		return developerName;
	}

	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	
	
}
