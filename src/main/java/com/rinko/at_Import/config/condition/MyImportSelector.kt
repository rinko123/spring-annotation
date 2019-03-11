package com.rinko.at_Import.config.condition

import org.springframework.context.annotation.ImportSelector
import org.springframework.core.type.AnnotationMetadata

//自定义逻辑返回需要导入的组件
class MyImportSelector : ImportSelector {

    //返回值，就是到导入到容器中的组件全类名
    //AnnotationMetadata:当前标注@Import注解的类的所有注解信息
    override fun selectImports(importingClassMetadata: AnnotationMetadata): Array<String> {
        //importingClassMetadata
        //方法不要返回null值
        return arrayOf("com.rinko.at_Import.entity.Green", "com.rinko.at_Import.entity.Blue")
    }

}
