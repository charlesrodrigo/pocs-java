package com.app.archunitexamples.architecture;


import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Controller;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.app.archunitexamples")
public class ControllerRulesTest {

    @ArchTest
    static ArchRule classes_that_have_controller_annotation_should_controller_end_name =
            classes()
                    .that().areAnnotatedWith(Controller.class)
                    .should().haveSimpleNameEndingWith("Controller");

    @ArchTest
    static ArchRule classes_that_have_controller_end_name_should_have_controller_annotation =
            classes()
                    .that().haveSimpleNameEndingWith("Controller")
                    .should().beAnnotatedWith(Controller.class);

}
