package org.talentboost.networkforgiving;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class NetworkForGivingApplication {
    @Value("${cors.origins}")
    private String origins;

    public static void main(String[] args) {
        SpringApplication.run(NetworkForGivingApplication.class, args);
    }

    // Allow cross origin requests
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/*")
                        .allowedOrigins(origins)
                        .allowCredentials(true);
            }
        };
    }
}
