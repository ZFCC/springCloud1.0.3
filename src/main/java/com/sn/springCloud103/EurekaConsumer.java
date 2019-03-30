package com.sn.springCloud103;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@RibbonClient(name="eureka-provider",configuration=RibbonConfig.class)
@SpringBootApplication
@EnableEurekaClient
public class EurekaConsumer {

	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumer.class, args);
	}

	//添加负载均衡
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
