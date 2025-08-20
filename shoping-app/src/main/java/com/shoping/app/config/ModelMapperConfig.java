package com.shoping.app.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

        @Bean
        public ModelMapper modelMapper() {

            return new ModelMapper();
//            ModelMapper modelMapper = new ModelMapper();
//
//            // Optional custom configuration
//            modelMapper.getConfiguration()
//                    .setFieldMatchingEnabled(true)
//                    .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
//
//            return modelMapper;
      }
}
