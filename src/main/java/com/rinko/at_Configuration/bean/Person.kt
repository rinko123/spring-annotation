package com.rinko.at_Configuration.bean

import org.springframework.stereotype.Component

/**
 * create by liuliang on 2019/3/6.
 */
@Component
class Person() {

    var id: Int = 0

    var name: String = "未命名"

    constructor(id: Int, name: String) : this() {
        this.id = id
        this.name = name
    }

    override fun toString(): String {
        return "Person(id=$id, name='$name')"
    }

    fun init() {
        println("测试@Bean的initMethod")
    }

    fun destroy() {
        println("测试@Bean的destroyMethod")
    }


}
