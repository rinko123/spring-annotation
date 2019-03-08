package com.rinko.at_Conditional.config


import com.rinko.at_Conditional.bean.Person
import com.rinko.at_Conditional.config.condition.LinuxCondition
import com.rinko.at_Conditional.config.condition.WindowsCondition

import org.springframework.context.annotation.*

/**
 * create by liuliang on 2019/3/6.
 */
@Configuration
class MainConfig {

    /**
     * @Conditional({Condition}) ： 按照一定的条件进行判断，满足条件给容器中注册bean
     *
     * 如果系统是windows，给容器中注册("bill")
     * 如果是linux系统，给容器中注册("linus")
     */

    @Bean("bill")
    @Conditional(WindowsCondition::class)
    fun person02(): Person {
        return Person(2, "bill")
    }

    @Bean("linus")
    @Conditional(LinuxCondition::class)
    fun person03(): Person {
        return Person(3, "linus")
    }


}
