package com.rinko.at_EnableAspectJAutoProxy.config

import com.rinko.at_EnableAspectJAutoProxy.bean.MathCalculator
import com.rinko.at_EnableAspectJAutoProxy.config.aop.LogAspects
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy

/**
 * create by liuliang on 2019/3/6.
 */
@Configuration
@EnableAspectJAutoProxy //开启基于注解的aop模式
class MainConfig {

//    /**
//     * 业务逻辑类加入容器中 这种不行不过@Component可以
//     */
//    @Bean
//    fun mathCalculator(): MathCalculator {
//        return MathCalculator()
//    }

    /**
     * 切面类加入到容器中
     */
    @Bean
    fun logAspects(): LogAspects {
        return LogAspects()
    }
}





