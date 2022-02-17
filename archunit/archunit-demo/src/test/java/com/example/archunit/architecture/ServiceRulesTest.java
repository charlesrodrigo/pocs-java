package com.example.archunit.architecture;


import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchIgnore;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "com.example.archunit", importOptions = ImportOption.DoNotIncludeTests.class)
public class ServiceRulesTest {


    @ArchIgnore
    @ArchTest
    static final ArchRule classes_that_resideInAPackage_service_should_beInterfaces =
            classes().that().resideInAPackage("..service").should().beInterfaces();

    @ArchIgnore
    @ArchTest
    static final ArchRule noClasses_that_resideInAPackage_impl_should_beInterfaces =
            noClasses().that().resideInAPackage("..impl..").should().beInterfaces();


    @ArchIgnore
    @ArchTest
    static ArchRule classes_that_resideInAPackage_impl_should_beAnnotatedWith_Service =
            classes()
                    .that().resideInAPackage("..impl..")
                    .should().beAnnotatedWith(Service.class);


    @ArchIgnore
    @ArchTest
    static ArchRule classes_that_areAnnotatedWith_service_should_haveSimpleNameEndingWith_ServiceImpl =
            classes()
                    .that().areAnnotatedWith(Service.class)
                    .should().haveSimpleNameEndingWith("ServiceImpl");

    @ArchIgnore
    @ArchTest
    static ArchRule classes_that_areAnnotatedWith_Service_should_notBePublic =
            classes()
                    .that().areAnnotatedWith(Service.class)
                    .should().notBePublic();


}
