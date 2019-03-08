package com.rinko.at_Scope.config


import com.rinko.at_Scope.bean.Person
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Lazy
import org.springframework.context.annotation.Scope

/**
 * create by liuliang on 2019/3/6.
 */
@Configuration
class MainConfig {

    @Bean
    @Scope(value = "prototype") //默认用的时候初始化
    fun person02(): Person {
        println("02 init")
        return Person(2, "person02")
    }

    @Bean
    @Scope(value = "singleton") //默认直接初始化
    fun person03(): Person {
        println("03 init")
        return Person(3, "person03")
    }

    @Bean
    @Scope(value = "prototype") //强制初始化
    @Lazy(value = false)    //没暖用、好像注入04的时候才会直接初始化
    fun person04(): Person {
        println("04 init")
        return Person(4, "person04")
    }

    @Bean
    @Scope(value = "singleton") //强制不初始化
    @Lazy(value = true) //若有地方注入则无视此注解直接初始化
    fun person05(): Person {
        println("05 init")
        return Person(5, "person05")
    }

}
