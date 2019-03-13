package com.rinko.at_EnableAspectJAutoProxy.bean

import org.springframework.stereotype.Component

@Component
class MathCalculator {

    /**
     * 获得除法算式
     */
    fun getDivFormula(prefix: String, i: Int, j: Int): String {
        println("MathCalculator...div...")
        return "$prefix $i / $j = ${i / j}"
    }

}
