package com.rinko.at_Configuration.config

import com.rinko.at_Configuration.MainApplication
import com.rinko.at_Configuration.bean.Person
import com.rinko.at_Configuration.bean.PersonController
import com.rinko.at_Configuration.bean.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.ApplicationRunner
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.annotation.Resource

/**
 * create by liuliang on 2019/3/6.
 */
@Configuration
class InitConfig {

    //注册了10个bean
    //=== person
    //=== person02
    //=== person自定义
    //=== person自定义2
    //=== person05
    //=== personController
    //=== personService
    //=== mainConfig
    //=== initConfig
    //=== mainApplication
    @Autowired(required = false)    //required不知道有啥用
    private lateinit var personService: PersonService

    @Autowired  //@Autowired 默认按类型找不过找到了多个、然后按属性名person05找
    @Qualifier(value = "person02")  //标注了@Qualifier注解则强制按照这个值person02找 报红是因为有不止一个@SpringBootApplication标注的类 Autowiring for Bean Class 勾去掉解除报红
    private lateinit var person05: Person

    @Resource   //不测。
    private lateinit var person自定义: Person

    @Bean
    fun init(applicationContext: ApplicationContext): ApplicationRunner {
        return ApplicationRunner {

            println(person05)   //Person(id=2, name='person02')

            println(person自定义)  //Person(id=3, name='person03')

            val beanNames =
                    applicationContext.getBeanNamesForType(Person::class.java)
                            .plus(applicationContext.getBeanNamesForType(PersonController::class.java))
                            .plus(applicationContext.getBeanNamesForType(PersonService::class.java))

                            .plus(applicationContext.getBeanNamesForType(MainConfig::class.java))
                            .plus(applicationContext.getBeanNamesForType(InitConfig::class.java))
                            .plus(applicationContext.getBeanNamesForType(MainApplication::class.java))

            println("注册了${beanNames.size}个bean")
            for (beanName in beanNames) {
                println(String.format("=== %s", beanName))

            }
        }
    }
}
