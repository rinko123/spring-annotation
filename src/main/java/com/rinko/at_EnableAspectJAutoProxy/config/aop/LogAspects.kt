package com.rinko.at_EnableAspectJAutoProxy.config.aop

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.*
import java.util.Arrays

/**
 * 切面类
 * @author lfy
 *
 * @Aspect： 告诉Spring当前类是一个切面类
 */
@Aspect
class LogAspects {

    //抽取公共的切入点表达式
    //1、本类引用
    //2、其他的切面引用
    @Pointcut("execution(* com.rinko.at_EnableAspectJAutoProxy.bean.*.*(..))")
    fun pointCut() {
    }

    /**
     * @Before在目标方法之前切入；切入点表达式（指定在哪个方法切入）
     * 获得方法名、参数列表
     */
    @Before("pointCut()")
    fun logStart(joinPoint: JoinPoint) {
        val args = joinPoint.args
        println("" + joinPoint.signature.name + "运行。。。@Before:参数列表是：{" + Arrays.asList(*args) + "}")
    }

    @After("com.rinko.at_EnableAspectJAutoProxy.config.aop.LogAspects.pointCut()")
    fun logEnd(joinPoint: JoinPoint) {
        println("" + joinPoint.signature.name + "结束。。。@After")
    }

    /**
     * JoinPoint一定要出现在参数表的第一位
     * 获取返回值
     */
    @AfterReturning(value = "pointCut()", returning = "result")
    fun logReturn(joinPoint: JoinPoint, result: Any) {
        println("" + joinPoint.signature.name + "正常返回。。。@AfterReturning:运行结果：{" + result + "}")
    }

    /**
     * 获取异常信息
     */
    @AfterThrowing(value = "pointCut()", throwing = "exception")
    fun logException(joinPoint: JoinPoint, exception: Exception) {
        println("" + joinPoint.signature.name + "异常。。。异常信息：{" + exception + "}")
    }

}

