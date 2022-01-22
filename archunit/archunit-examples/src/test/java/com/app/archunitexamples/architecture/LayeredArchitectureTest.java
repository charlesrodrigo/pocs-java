package com.app.archunitexamples.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchIgnore;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.app.archunitexamples.architecture.ArchitectureUtilTest.*;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;
import static com.tngtech.archunit.library.DependencyRules.NO_CLASSES_SHOULD_DEPEND_UPPER_PACKAGES;

@AnalyzeClasses(packages = "com.app.archunitexamples", importOptions = ImportOption.DoNotIncludeTests.class)
public class LayeredArchitectureTest {

    @ArchTest
    static final ArchRule layer_dependencies_are_respected = layeredArchitecture()
            .layer(DOMAIN_LAYER).definedBy(DOMAIN_LAYER_PACKAGES)
            .layer(API_LAYER).definedBy(API_LAYER_PACKAGES)
            .layer(WORKER_LAYER).definedBy(WORKER_LAYER_PACKAGES)

            .whereLayer(API_LAYER).mayNotBeAccessedByAnyLayer()
            .whereLayer(WORKER_LAYER).mayNotBeAccessedByAnyLayer()
            .whereLayer(DOMAIN_LAYER).mayOnlyBeAccessedByLayers(API_LAYER, WORKER_LAYER);


    @ArchIgnore
    @ArchTest
    static final ArchRule no_accesses_to_upper_package = NO_CLASSES_SHOULD_DEPEND_UPPER_PACKAGES;

}
