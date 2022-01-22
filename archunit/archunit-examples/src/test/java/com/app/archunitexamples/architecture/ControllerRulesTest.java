package com.app.archunitexamples.architecture;


import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.app.archunitexamples", importOptions = ImportOption.DoNotIncludeTests.class)
public class ControllerRulesTest {

    @ArchTest
    static ArchRule classes_that_have_controller_annotation_should_controller_end_name =
            classes()
                    .that().areAnnotatedWith(Controller.class).or().areAnnotatedWith(RestController.class)
                    .should().haveSimpleNameEndingWith("Controller");

    @ArchTest
    static ArchRule classes_that_have_controller_end_name_should_have_controller_annotation =
            classes()
                    .that().haveSimpleNameEndingWith("Controller")
                    .should().beAnnotatedWith(Controller.class).orShould().beAnnotatedWith(RestController.class);

    @ArchTest
    static ArchRule classes_that_have_controller_annotation_name_should_be_in_the_package_api =
            classes()
                    .that().areAnnotatedWith(Controller.class).or().areAnnotatedWith(RestController.class)
                    .should().resideInAPackage("..api..");

    @ArchTest
    static ArchRule classes_that_have_controller_annotation_should_not_be_public_access =
            classes()
                    .that().areAnnotatedWith(Controller.class).or().areAnnotatedWith(RestController.class)
                    .should().notBePublic();

}
