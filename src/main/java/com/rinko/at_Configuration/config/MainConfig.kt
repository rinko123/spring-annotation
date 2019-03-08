package com.rinko.at_Configuration.config

import com.rinko.at_Configuration.bean.Person
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * create by liuliang on 2019/3/6.
 */
@Configuration
class MainConfig {

    @Bean
    fun person02(): Person {
        return Person(2, "person02")
    }

    @Bean(value = ["person自定义"])    //默认
    fun person03(): Person {
        return Person(3, "person03")
    }

    @Bean(name = ["person自定义2"])
    fun person04(): Person {
        return Person(4, "person04")
    }

    //    @Bean(autowireCandidate = false) 蛋疼不用。。
    @Bean(initMethod = "init", destroyMethod = "destroy")
    fun person05(): Person {
        return Person(5, "person05")
    }
}
