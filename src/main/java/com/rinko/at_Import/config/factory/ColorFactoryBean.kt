package com.rinko.at_Import.config.factory

import com.rinko.at_Import.entity.Color
import org.springframework.beans.factory.FactoryBean

//创建一个Spring定义的FactoryBean
class ColorFactoryBean : FactoryBean<Color> {

    //返回一个Color对象，这个对象会添加到容器中
    @Throws(Exception::class)
    override fun getObject(): Color? {
        println("ColorFactoryBean...getObject...")
        return Color()
    }

    override fun getObjectType(): Class<*>? {
        return Color::class.java
    }

    //是单例？
    //true：这个bean是单实例，在容器中保存一份
    //false：多实例，每次获取都会创建一个新的bean；
    override fun isSingleton(): Boolean {
        return false
    }

}
