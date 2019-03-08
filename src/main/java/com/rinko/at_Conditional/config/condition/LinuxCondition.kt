package com.rinko.at_Conditional.config.condition

import org.springframework.context.annotation.Condition
import org.springframework.context.annotation.ConditionContext
import org.springframework.core.type.AnnotatedTypeMetadata

//判断是否linux系统
class LinuxCondition : Condition {

    /**
     * ConditionContext：判断条件能使用的上下文（环境）
     * AnnotatedTypeMetadata：注释信息
     */
    override fun matches(context: ConditionContext, metadata: AnnotatedTypeMetadata): Boolean {
        //1、能获取到ioc使用的beanFactory
        val beanFactory = context.beanFactory   //也可以创建bean

        //2、获取类加载器
        val classLoader = context.classLoader
        //3、获取当前环境信息
        val environment = context.environment
        //4、获取到bean定义的注册类
        val registry = context.registry //context.registry.beanDefinitionNames 所有bean的名称

        val property = environment.getProperty("os.name")

        //可以判断容器中的bean注册情况，也可以给容器中注册bean
        val definition = registry.containsBeanDefinition("person")
        return property!!.contains("linux")

    }

}
