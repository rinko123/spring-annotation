package com.rinko.at_Import.config


import com.rinko.at_Import.bean.Person
import com.rinko.at_Import.config.factory.ColorFactoryBean
import com.rinko.at_Import.entity.*
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
    private lateinit var color: Color   //只要注册了工厂bean就可以直接注入color使用

    @Bean
    fun init(applicationContext: ApplicationContext): ApplicationRunner {
        return ApplicationRunner {

            println(color)

            val beanNames =
                    applicationContext.getBeanNamesForType(Person::class.java)
                            .plus(applicationContext.getBeanNamesForType(Red::class.java))
                            .plus(applicationContext.getBeanNamesForType(Green::class.java))
                            .plus(applicationContext.getBeanNamesForType(Blue::class.java))
                            .plus(applicationContext.getBeanNamesForType(Rainbow::class.java))
                            .plus(applicationContext.getBeanNamesForType(Color::class.java))
                            .plus(applicationContext.getBeanNamesForType(ColorFactoryBean::class.java))

            applicationContext.getBean("colorFactoryBean")  //类型为Color::class.java
            applicationContext.getBean("&colorFactoryBean") //类型为ColorFactoryBean::class.java


            println("注册了${beanNames.size}个bean")
            for (beanName in beanNames) {
                println(String.format("=== %s", beanName))

            }

        }
    }
}
