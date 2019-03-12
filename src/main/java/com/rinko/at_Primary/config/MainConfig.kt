package com.rinko.at_Primary.config

import com.rinko.at_Primary.bean.Person
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

/**
 * create by liuliang on 2019/3/6.
 */
@Configuration
class MainConfig {

    @Bean
    @Primary
    fun person02(): Person {
        return Person(2, "Primary Person")
    }

}



