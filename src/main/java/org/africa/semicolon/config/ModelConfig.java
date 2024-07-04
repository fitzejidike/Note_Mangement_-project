package org.africa.semicolon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

@Configuration
public class ModelConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper ();
    }
}
