package com.rinko.at_Conditional.config


import com.rinko.at_Conditional.bean.Person
import org.springframework.boot.ApplicationRunner
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * create by liuliang on 2019/3/6.
 */
@Configuration
class InitConfig {

    @Bean
    fun init(applicationContext: ApplicationContext): ApplicationRunner {
        return ApplicationRunner {

            val beanNames =
                    applicationContext.getBeanNamesForType(Person::class.java)

            println("注册了${beanNames.size}个bean")
            for (beanName in beanNames) {
                println(String.format("=== %s", beanName))

            }

        }
    }
}
