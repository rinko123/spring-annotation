package com.rinko.at_PostConstruct.config


import com.rinko.at_PostConstruct.entity.Bird
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * create by liuliang on 2019/3/6.
 */
@Configuration
class MainConfig {

    @Bean(initMethod = "init1", destroyMethod = "destroy1")
    fun bird(): Bird {
        return Bird()
    }
}



