package com.app.archunitexamples.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchIgnore;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.GeneralCodingRules;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.fields;


@AnalyzeClasses(packages = "com.app.archunitexamples")
public class GeneralCodingRulesTest {

    @ArchIgnore
    @ArchTest
    static final ArchRule no_classes_should_use_access_standard_streams = GeneralCodingRules.NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS;

    @ArchIgnore
    @ArchTest
    static final ArchRule no_classes_should_throw_generic_exceptions = GeneralCodingRules.NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS;

    @ArchIgnore
    @ArchTest
    static final ArchRule no_classes_should_use_java_util_logging = GeneralCodingRules.NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING;

    @ArchTest
    static final ArchRule no_classes_should_field_injection = GeneralCodingRules.NO_CLASSES_SHOULD_USE_FIELD_INJECTION;

    @ArchIgnore
    @ArchTest
    private final ArchRule loggers_should_be_private_static_final =
            fields().that().haveRawType(Logger.class)
                    .should().bePrivate()
                    .andShould().beStatic()
                    .andShould().beFinal()
                    .because("we agreed on this convention");

    @ArchTest
    static final ArchRule spring_singleton_components_should_only_have_final_fields =
            classes()
                    .that().areAnnotatedWith(Service.class)
                    .or().areAnnotatedWith(Component.class)
                    .and().areNotAnnotatedWith(ConfigurationProperties.class)
                    .or().areAnnotatedWith(Controller.class)
                    .or().areAnnotatedWith(RestController.class)
                    .or().areAnnotatedWith(Repository.class)
                    .should().haveOnlyFinalFields();


}
