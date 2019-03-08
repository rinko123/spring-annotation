package com.rinko.at_Conditional.config


import com.rinko.at_Conditional.bean.Person
import com.rinko.at_Conditional.config.condition.LinuxCondition
import com.rinko.at_Conditional.config.condition.WindowsCondition

import org.springframework.context.annotation.*

/**
 * create by liuliang on 2019/3/6.
 */
@Configuration
@Conditional(WindowsCondition::class)   //也可标注类上
class MainConfig2 {

    @Bean
    fun person022(): Person {
        return Person(22, "bill")
    }

    @Bean
    fun person033(): Person {
        return Person(33, "linus")
    }


}
