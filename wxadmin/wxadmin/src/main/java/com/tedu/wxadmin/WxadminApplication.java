package com.tedu.wxadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages= {"com.tedu.wxadmin"})
@MapperScan(basePackages= {"com.tedu.wxadmin.mapper"})//扫描mapper
public class WxadminApplication {

	public static void main(String[] args) {
		SpringApplication.run(WxadminApplication.class, args);
	}

}
