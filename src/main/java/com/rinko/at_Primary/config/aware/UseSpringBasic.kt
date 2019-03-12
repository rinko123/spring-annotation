package com.rinko.at_Primary.config.aware

import org.springframework.beans.BeansException
import org.springframework.beans.factory.BeanNameAware
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.context.EmbeddedValueResolverAware
import org.springframework.stereotype.Component
import org.springframework.util.StringValueResolver

/**
 * 自定义组件想要使用Spring容器底层的一些组件（ApplicationContext，BeanFactory，xxx）；
 * 自定义组件实现xxxAware；在创建对象的时候，会调用接口规定的方法注入相关组件；Aware；
 * 把Spring底层一些组件注入到自定义的Bean中；
 * xxxAware：功能使用xxxProcessor 后置处理器来进行实现的
 * ApplicationContextAware==》ApplicationContextAwareProcessor；
 */
@Component
class UseSpringBasic : ApplicationContextAware    //实现以获取IOC容器对象
        , BeanNameAware //实现以获取bean的名字
        , EmbeddedValueResolverAware {  //实现以获取string解析器

    private var applicationContext: ApplicationContext? = null

    @Throws(BeansException::class)
    override fun setApplicationContext(applicationContext: ApplicationContext) {
        println("传入的ioc：$applicationContext")
        this.applicationContext = applicationContext
    }

    override fun setBeanName(name: String) {
        println("当前bean的名字：$name")
    }

    override fun setEmbeddedValueResolver(resolver: StringValueResolver) {
        val resolveStringValue = resolver.resolveStringValue("你好 \${os.name} 我是 #{20*18}")
        println("解析的字符串：" + resolveStringValue!!)
    }

}
