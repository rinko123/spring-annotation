package com.rinko.at_PropertySource.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.ApplicationRunner
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * create by liuliang on 2019/3/6.
 */
@Configuration
class InitConfig {

    @Value("\${server.port}")
    private lateinit var port: String

    @Value("\${person.hello}")
    private lateinit var hello: String

    @Bean
    fun init(applicationContext: ApplicationContext): ApplicationRunner {
        return ApplicationRunner {

            println("配置文件中的hello：$hello")
            println("配置文件中的port：$port")

        }
    }
}
