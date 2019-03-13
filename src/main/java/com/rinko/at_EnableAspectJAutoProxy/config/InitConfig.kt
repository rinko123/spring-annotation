package com.rinko.at_EnableAspectJAutoProxy.config

import com.rinko.at_EnableAspectJAutoProxy.bean.MathCalculator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationRunner
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * create by liuliang on 2019/3/6.
 */
@Configuration
class InitConfig {

    @Autowired
    private lateinit var mathCalculator: MathCalculator

    @Bean
    fun init(applicationContext: ApplicationContext): ApplicationRunner {
        return ApplicationRunner {

            mathCalculator.getDivFormula("除法算式：", 6, 2)

        }
    }
}
