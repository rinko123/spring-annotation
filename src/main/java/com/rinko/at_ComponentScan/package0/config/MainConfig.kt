package com.rinko.at_ComponentScan.package0.config

import com.rinko.at_ComponentScan.package2.DogController
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.ComponentScan.Filter
import org.springframework.context.annotation.ComponentScans
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType
import org.springframework.stereotype.Component
import org.springframework.stereotype.Controller
import org.springframework.stereotype.Service


/**
 * create by liuliang on 2019/3/6.
 */
@Configuration
//@ComponentScan(value = "com.rinko.at_ComponentScan.package1") //默认 同下 basePackages

//@ComponentScan(basePackages = ["com.rinko.at_ComponentScan.package1", "com.rinko.at_ComponentScan.package2"])   //扫描两个包里的bean

//@ComponentScan(basePackageClasses =  [Cat::class])  // 扫描这个类、是bean则加入容器

//@ComponentScan(value = ["com.rinko.at_ComponentScan.package2"],
//        useDefaultFilters = false,  // 设置false includeFilters、excludeFilters 才能生效
//        includeFilters = [Filter(type = FilterType.ANNOTATION, value = [Component::class])],  //扫描包内@Component（@C@R@S@R四个都算）标注的bean
//        excludeFilters = [ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = [DogController::class])]) //排除DogController类的bean

@ComponentScans(value = [ComponentScan(value = ["com.rinko.at_ComponentScan.package2"],
        useDefaultFilters = false,  // 设置false includeFilters、excludeFilters 才能生效
        includeFilters = [Filter(type = FilterType.ANNOTATION, value = [Component::class])],  //扫描包内@Component（@C@R@S@R四个都算）标注的bean
        excludeFilters = [ComponentScan.Filter(type = FilterType.CUSTOM, value = [MyTypeFilter::class])])] //排除自自定义规则的bean
)
class MainConfig

