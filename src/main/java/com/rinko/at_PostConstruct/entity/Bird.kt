package com.rinko.at_PostConstruct.entity

import org.springframework.beans.factory.DisposableBean
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.config.BeanPostProcessor
import javax.annotation.PreDestroy
import javax.annotation.PostConstruct



/**
 * 生命周期方法实现
 *create by liuliang on 2019/3/11.
 */
class Bird : InitializingBean, DisposableBean, BeanPostProcessor {

    /**
     * 通过@Bean指定init-method、destroy-method
     */
    fun init1(){
        println("@Bean init...")    //第3打印
    }

    fun destroy1(){
        println("@Bean destroy...")
    }

    /**
     * 通过让Bean实现InitializingBean、DisposableBean
     */
    override fun afterPropertiesSet() {
        println("InitializingBean init...") //第2打印
    }

    override fun destroy() {
        println("DisposableBean destroy...")
    }

    /**
     * 可以使用JSR250注解@PostConstruct、@PreDestroy
     */
    @PostConstruct
    fun init3(){
        println("@PostConstruct init...")   //第1打印
    }

    @PreDestroy
    fun destroy3(){
        println("@PreDestroy destroy...")
    }

    /**
     * bean的后置处理器，在bean初始化前后进行一些处理工作，一个bean实现这个接口则所有bean受控制
     */
    override fun postProcessBeforeInitialization(bean: Any, beanName: String): Any? {
        println("BeanPostProcessor init...")    //第4打印
        return bean
    }

    override fun postProcessAfterInitialization(bean: Any, beanName: String): Any? {
        println("BeanPostProcessor destroy...") //第5打印
        return bean
    }


}