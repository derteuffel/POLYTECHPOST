package com.derteuffel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by derteuffel on 10/02/2019.
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
}
