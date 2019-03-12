package com.rinko.at_Profile.bean

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

/**
 * create by liuliang on 2019/3/6.
 */
@Component
@Profile("dev")
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

}
