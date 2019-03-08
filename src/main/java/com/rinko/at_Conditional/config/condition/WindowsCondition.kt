package com.rinko.at_Conditional.config.condition

import org.springframework.context.annotation.Condition
import org.springframework.context.annotation.ConditionContext
import org.springframework.core.type.AnnotatedTypeMetadata

//判断是否windows系统
class WindowsCondition : Condition {

    override fun matches(context: ConditionContext, metadata: AnnotatedTypeMetadata): Boolean {
        val environment = context.environment
        val property = environment.getProperty("os.name")
        return property!!.contains("Windows")
    }

}
