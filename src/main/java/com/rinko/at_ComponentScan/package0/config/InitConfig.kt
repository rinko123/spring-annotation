package com.rinko.at_ComponentScan.package0.config

import com.rinko.at_ComponentScan.package0.bean.Person
import com.rinko.at_ComponentScan.package1.Cat
import com.rinko.at_ComponentScan.package2.Dog
import com.rinko.at_ComponentScan.package2.DogController
import com.rinko.at_ComponentScan.package2.DogService
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
                            .plus(applicationContext.getBeanNamesForType(Cat::class.java))
                            .plus(applicationContext.getBeanNamesForType(Dog::class.java))
                            .plus(applicationContext.getBeanNamesForType(DogService::class.java))
                            .plus(applicationContext.getBeanNamesForType(DogController::class.java))

            println("注册了${beanNames.size}个bean")
            for (beanName in beanNames) {
                println(String.format("=== %s", beanName))

            }
        }
    }
}
