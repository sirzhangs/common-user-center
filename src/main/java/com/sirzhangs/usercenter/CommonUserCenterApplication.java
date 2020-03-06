package com.sirzhangs.usercenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.sirzhangs.common.util.RedisUtil;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@MapperScan("com.sirzhangs.usercenter.mapper")
public class CommonUserCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonUserCenterApplication.class, args);
	}
	
	@Bean
	public RedisUtil redisUtil() {
		return new RedisUtil();
	}

}
