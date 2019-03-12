package com.rinko.at_Primary.config

import com.rinko.at_Primary.bean.Person
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
//    @Qualifier("person")  // 加上此注解才能注入非primary的该类型bean
    private lateinit var person: Person

    @Bean
    fun init(applicationContext: ApplicationContext): ApplicationRunner {
        return ApplicationRunner {

            println(person) //Person(id=2, name='Primary Person') 因为bean person02 上指定了@Primary

            val beanNames =
                    applicationContext.getBeanNamesForType(Person::class.java)

            println("注册了${beanNames.size}个bean")
            for (beanName in beanNames) {
                println(String.format("=== %s", beanName))

            }

        }
    }
}
