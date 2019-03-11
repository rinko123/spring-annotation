package com.rinko.at_Import.config


import com.rinko.at_Import.config.condition.MyImportBeanDefinitionRegistrar
import com.rinko.at_Import.config.condition.MyImportSelector
import com.rinko.at_Import.config.factory.ColorFactoryBean
import com.rinko.at_Import.entity.Red
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

/**
 * create by liuliang on 2019/3/6.
 */
@Configuration
@Import(Red::class,   //可直接注入
        MyImportSelector::class,    //可同过实现了ImportSelector的类实现
        MyImportBeanDefinitionRegistrar::class  //也可通过实现了ImportBeanDefinitionRegistrar的类实现
)
class MainConfig{

    @Bean
    fun colorFactoryBean(): ColorFactoryBean {
        return ColorFactoryBean()
    }
}



