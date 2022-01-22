package com.app.archunitexamples.architecture;


import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "com.app.archunitexamples")
public class ServiceRulesTest {

    @ArchTest
    static ArchRule classes_that_have_service_annotation_should_service_end_name =
            classes()
                    .that().areAnnotatedWith(Service.class)
                    .should().haveSimpleNameEndingWith("ServiceImpl");

    @ArchTest
    static ArchRule classes_that_have_service_end_name_should_have_service_annotation =
            classes()
                    .that().haveSimpleNameEndingWith("ServiceImpl")
                    .should().beAnnotatedWith(Service.class);

    @ArchTest
    static final ArchRule interfaces_must_not_be_placed_in_implementation_packages =
            noClasses().that().resideInAPackage("..impl..").should().beInterfaces();


    @ArchTest
    static ArchRule classes_that_have_serviceimpl_end_name_should_be_in_the_package_impl =
            classes()
                    .that().haveSimpleNameEndingWith("ServiceImpl")
                    .should().resideInAPackage("..impl..");

}
