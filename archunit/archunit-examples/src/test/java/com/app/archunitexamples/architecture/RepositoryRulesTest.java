package com.app.archunitexamples.architecture;


import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Repository;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.app.archunitexamples")
public class RepositoryRulesTest {

    @ArchTest
    static ArchRule classes_that_have_respository_annotation_should_respository_end_name =
            classes()
                    .that().areAnnotatedWith(Repository.class)
                    .should().haveSimpleNameEndingWith("Repository");

    @ArchTest
    static ArchRule classes_that_have_respository_end_name_should_have_respository_annotation =
            classes()
                    .that().haveSimpleNameEndingWith("Repository")
                    .should().beAnnotatedWith(Repository.class);

    
}
