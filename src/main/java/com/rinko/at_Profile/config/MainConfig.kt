package com.rinko.at_Profile.config

import com.rinko.at_Profile.bean.Person
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

/**
 * create by liuliang on 2019/3/6.
 */
@Configuration
class MainConfig {

    @Bean
    @Profile("test")
    fun personTest(): Person {
        return Person(2, "person test")
    }

    @Bean
    @Profile("dev")
    fun personDev(): Person {
        return Person(3, "person dev")
    }

    @Bean
    @Profile("prod")
    fun personProd(): Person {
        return Person(4, "person prod")
    }

}



