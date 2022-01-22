package com.app.archunitexamples.architecture;


import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Component;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.app.archunitexamples")
public class ComponentRulesTest {

  
    @ArchTest
    static ArchRule classes_that_have_component_annotation_should_component_end_name =
            classes()
                    .that().areAnnotatedWith(Component.class)
                    .should().haveSimpleNameEndingWith("Component");

    @ArchTest
    static ArchRule classes_that_have_component_end_name_should_have_component_annotation =
            classes()
                    .that().haveSimpleNameEndingWith("Component")
                    .should().beAnnotatedWith(Component.class);


}
