package com.app.archunitexamples.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.GeneralCodingRules;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.fields;


@AnalyzeClasses(packages = "com.app.archunitexamples", importOptions = ImportOption.DoNotIncludeTests.class)
public class GeneralCodingRulesTest {

    // system.out ou system.err ou
    @ArchTest
    static final ArchRule no_classes_should_use_access_standard_streams = GeneralCodingRules.NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS;

    @ArchTest
    static final ArchRule no_classes_should_throw_generic_exceptions = GeneralCodingRules.NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS;

    @ArchTest
    static final ArchRule no_classes_should_use_java_util_logging = GeneralCodingRules.NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING;

    @ArchTest
    static final ArchRule no_classes_should_field_injection = GeneralCodingRules.NO_CLASSES_SHOULD_USE_FIELD_INJECTION;

    @ArchTest
    private final ArchRule loggers_should_be_private_static_final =
            fields().that().haveRawType(Logger.class)
                    .should().bePrivate()
                    .andShould().beStatic()
                    .andShould().beFinal();

    @ArchTest
    static final ArchRule singleton_components_should_only_have_final_fields =
            classes()
                    .that().areAnnotatedWith(Service.class)
                    .or().areAnnotatedWith(Component.class)
                    .and().areNotAnnotatedWith(ConfigurationProperties.class)
                    .or().areAnnotatedWith(Controller.class)
                    .or().areAnnotatedWith(RestController.class)
                    .or().areAnnotatedWith(Repository.class)
                    .should().haveOnlyFinalFields();


}
