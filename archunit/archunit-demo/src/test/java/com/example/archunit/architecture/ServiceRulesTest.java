package com.example.archunit.architecture;


import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchIgnore;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "com.example.archunit", importOptions = ImportOption.DoNotIncludeTests.class)
public class ServiceRulesTest {

    @ArchIgnore
    @ArchTest
    static ArchRule classes_that_resideInAPackage_should_notBeAnnotatedWith_Component =
            classes()
                    .that().resideInAPackage("..service..")
                    .should().notBeAnnotatedWith(Component.class);

    @ArchIgnore
    @ArchTest
    static ArchRule classes_that_have_service_annotation_should_service_end_name =
            classes()
                    .that().areAnnotatedWith(Service.class)
                    .should().haveSimpleNameEndingWith("ServiceImpl");
    @ArchIgnore
    @ArchTest
    static ArchRule classes_that_have_serviceimpl_end_name_should_be_in_the_package_impl =
            classes()
                    .that().haveSimpleNameEndingWith("ServiceImpl")
                    .should().resideInAPackage("..impl..");


    // other tests, alter code for error
    @ArchIgnore
    @ArchTest
    static ArchRule classes_that_have_service_end_name_should_have_service_annotation =
            classes()
                    .that().haveSimpleNameEndingWith("ServiceImpl")
                    .should().beAnnotatedWith(Service.class);

    @ArchIgnore
    @ArchTest
    static final ArchRule interfaces_must_not_be_placed_in_implementation_packages =
            noClasses().that().resideInAPackage("..impl..").should().beInterfaces();

    @ArchIgnore
    @ArchTest
    static ArchRule classes_that_have_service_annotation_should_not_be_public_access =
            classes()
                    .that().areAnnotatedWith(Service.class)
                    .should().notBePublic();

}
