package com.app.archunitexamples.architecture;


import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Repository;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.app.archunitexamples", importOptions = ImportOption.DoNotIncludeTests.class)
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

    @ArchTest
    static ArchRule classes_that_have_controller_annotation_name_should_be_in_the_package_api =
            classes()
                    .that().areAnnotatedWith(Repository.class)
                    .should().resideInAPackage("..repo..");
}
