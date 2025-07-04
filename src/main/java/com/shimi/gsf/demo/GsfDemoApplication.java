package com.shimi.gsf.demo;

import com.shimi.gsf.config.GsfDefaultWebMvcConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(exclude= {SecurityAutoConfiguration.class})
@Import(GsfDefaultWebMvcConfig.class)
@EnableAsync
public class GsfDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(GsfDemoApplication.class, args);
    }
}
