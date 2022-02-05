package com.example.archunit.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchIgnore;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;


@AnalyzeClasses(packages = "com.example.archunit", importOptions = ImportOption.DoNotIncludeTests.class)
public class LayeredArchitectureTest {

    private static final String CONTROLLER_LAYER = "com.example.archunit.controller..";
    private static final String SERVICE_LAYER = "com.example.archunit.service..";
    private static final String REPOSITORY_LAYER = "com.example.archunit.repository..";
    private static final String MODEL_LAYER = "com.example.archunit.model..";;

    @ArchIgnore
    @ArchTest
    static final ArchRule layer_dependencies_are_respected = layeredArchitecture()
            .layer(CONTROLLER_LAYER).definedBy(CONTROLLER_LAYER)
            .layer(SERVICE_LAYER).definedBy(SERVICE_LAYER)
            .layer(REPOSITORY_LAYER).definedBy(REPOSITORY_LAYER)
            .layer(MODEL_LAYER).definedBy(MODEL_LAYER)

            .whereLayer(CONTROLLER_LAYER).mayNotBeAccessedByAnyLayer()
            .whereLayer(SERVICE_LAYER).mayOnlyBeAccessedByLayers(CONTROLLER_LAYER, SERVICE_LAYER)
            .whereLayer(REPOSITORY_LAYER).mayOnlyBeAccessedByLayers(SERVICE_LAYER)
            .whereLayer(MODEL_LAYER).mayOnlyBeAccessedByLayers(CONTROLLER_LAYER, SERVICE_LAYER, REPOSITORY_LAYER);

}
