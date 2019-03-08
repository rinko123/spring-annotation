package com.rinko.at_ComponentScan.package0.config

import org.springframework.core.type.classreading.MetadataReader
import org.springframework.core.type.classreading.MetadataReaderFactory
import org.springframework.core.type.filter.TypeFilter
import org.springframework.stereotype.Component
import java.io.IOException

class MyTypeFilter : TypeFilter {

    /**
     * metadataReader����ȡ���ĵ�ǰ����ɨ��������Ϣ
     * metadataReaderFactory:���Ի�ȡ�������κ�����Ϣ��
     */
    @Throws(IOException::class)
    override fun match(metadataReader: MetadataReader, metadataReaderFactory: MetadataReaderFactory): Boolean {
        //��ȡ��ǰ��ע�����Ϣ
        val annotationMetadata = metadataReader.annotationMetadata
        //��ȡ��ǰ����ɨ����������Ϣ
        val classMetadata = metadataReader.classMetadata
        //��ȡ��ǰ����Դ�����·����
        val resource = metadataReader.resource  //(resource as FileSystemResource).path G:/idea-project/atguigu-code/spring-annotation/target/classes/com/rinko/at_ComponentScan/package2/Dog.class

        val className = classMetadata.className

        println(matchAnnotation(Component::class.java,metadataReader))
        //println("--->$className")   //com.rinko.at_ComponentScan.package2.DogController
        return className.contains("ervice")
    }

    private fun matchAnnotation(annotationType: Class<*>, metadataReader: MetadataReader): Boolean {
        val metadata = metadataReader.annotationMetadata
        val ownAnnotation = metadata.hasAnnotation(annotationType.name) //hasAnnotation() ��Ҫ����������������
        val considerMetaAnnotations = true
        val metaOwnAnnotation = metadata.hasMetaAnnotation(annotationType.name) //hasMetaAnnotation()
        println("��ǰ���Ƿ����@${annotationType.simpleName}ע�⣺$ownAnnotation")
        println("�Ƿ���Ԫע�⣨ע�����ϱ�ע��ע�⣩��$considerMetaAnnotations")
        println("��ע��Ԫע���а���@${annotationType.simpleName}ע�⣺$metaOwnAnnotation")
        return ownAnnotation || (considerMetaAnnotations && metaOwnAnnotation)
    }

}
