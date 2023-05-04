package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@Configuration
@ComponentScan("org.example")
@PropertySource("application.properties")
public class Config {

    @Bean
    public BlockingQueue<String> arrayBlockingQueue() {
        BlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(1024);
        return arrayBlockingQueue;
    }
}
