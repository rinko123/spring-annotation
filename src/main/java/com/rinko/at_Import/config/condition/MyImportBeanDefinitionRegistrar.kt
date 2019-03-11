package com.rinko.at_Import.config.condition


import com.rinko.at_Import.entity.Rainbow
import org.springframework.beans.factory.support.BeanDefinitionRegistry
import org.springframework.beans.factory.support.RootBeanDefinition
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar
import org.springframework.core.type.AnnotationMetadata

class MyImportBeanDefinitionRegistrar : ImportBeanDefinitionRegistrar {

    /**
     * AnnotationMetadata：当前类的注解信息
     * BeanDefinitionRegistry:BeanDefinition注册类；
     * 把所有需要添加到容器中的bean；调用
     * BeanDefinitionRegistry.registerBeanDefinition手工注册进来
     */
    override fun registerBeanDefinitions(importingClassMetadata: AnnotationMetadata, registry: BeanDefinitionRegistry) {

        val definition = registry.containsBeanDefinition("com.rinko.at_Import.entity.Red")
        val definition2 = registry.containsBeanDefinition("com.rinko.at_Import.entity.Green")
        val definition3 = registry.containsBeanDefinition("com.rinko.at_Import.entity.Blue")
        if (definition && definition2 && definition3) {
            //指定Bean定义信息；（Bean的类型，Bean。。。）
            val beanDefinition = RootBeanDefinition(Rainbow::class.java)
            //注册一个Bean，指定bean名
            registry.registerBeanDefinition("rainBow", beanDefinition)
        }
    }

}
