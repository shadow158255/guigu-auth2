package com.example.worktext1.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
@Slf4j
@Configuration
public class WebMvcConfiguration {
    public WebMvcConfiguration(){
        log.debug("加载配置类：WebMvcConfiguration");
    }
}
