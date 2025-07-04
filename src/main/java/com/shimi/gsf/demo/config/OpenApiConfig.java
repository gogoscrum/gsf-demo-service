package com.shimi.gsf.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setDescription("Dev Server");

        Contact contact = new Contact();
        contact.setEmail("gsf@shimi-tech.com");
        contact.setName("Jimmy Lu");
        contact.setUrl("https://www.shimi-tech.com");

        Info info = new Info()
                .title("GSF demo project API")
                .version("1.0")
                .contact(contact)
                .description("Shimi GSF demo project API").termsOfService("https://www.shimi-tech.com/gsf/terms");

        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}