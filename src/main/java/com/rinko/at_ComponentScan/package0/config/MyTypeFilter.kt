package com.rinko.at_ComponentScan.package0.config

import org.springframework.core.type.classreading.MetadataReader
import org.springframework.core.type.classreading.MetadataReaderFactory
import org.springframework.core.type.filter.TypeFilter
import org.springframework.stereotype.Component
import java.io.IOException

class MyTypeFilter : TypeFilter {

    /**
     * metadataReader：读取到的当前正在扫描的类的信息
     * metadataReaderFactory:可以获取到其他任何类信息的
     */
    @Throws(IOException::class)
    override fun match(metadataReader: MetadataReader, metadataReaderFactory: MetadataReaderFactory): Boolean {
        //获取当前类注解的信息
        val annotationMetadata = metadataReader.annotationMetadata
        //获取当前正在扫描的类的类信息
        val classMetadata = metadataReader.classMetadata
        //获取当前类资源（类的路径）
        val resource = metadataReader.resource  //(resource as FileSystemResource).path G:/idea-project/atguigu-code/spring-annotation/target/classes/com/rinko/at_ComponentScan/package2/Dog.class

        val className = classMetadata.className

        println(matchAnnotation(Component::class.java,metadataReader))
        //println("--->$className")   //com.rinko.at_ComponentScan.package2.DogController
        return className.contains("ervice")
    }

    private fun matchAnnotation(annotationType: Class<*>, metadataReader: MetadataReader): Boolean {
        val metadata = metadataReader.annotationMetadata
        val ownAnnotation = metadata.hasAnnotation(annotationType.name) //hasAnnotation() 主要是这个方法和下面的
        val considerMetaAnnotations = true
        val metaOwnAnnotation = metadata.hasMetaAnnotation(annotationType.name) //hasMetaAnnotation()
        println("当前类是否包含@${annotationType.simpleName}注解：$ownAnnotation")
        println("是否考虑元注解（注解类上标注的注解）：$considerMetaAnnotations")
        println("标注的元注解中包含@${annotationType.simpleName}注解：$metaOwnAnnotation")
        return ownAnnotation || (considerMetaAnnotations && metaOwnAnnotation)
    }

}
