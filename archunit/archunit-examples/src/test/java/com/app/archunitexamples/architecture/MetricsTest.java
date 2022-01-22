package com.app.archunitexamples.architecture;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.domain.JavaPackage;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.library.metrics.*;

import java.util.Set;


@AnalyzeClasses(packages = "com.app")
public class MetricsTest {

    private static String PACKAGE = "com.app";
    private static String SUBPACKAGE = PACKAGE + ".archunitexamples";

    @ArchTest
    public void no_accesses_to_upper_package(JavaClasses classes) {
        Set<JavaPackage> packages = classes.getPackage(PACKAGE).getSubpackages();

        // These components can also be created in a package agnostic way, compare MetricsComponents.from(..)
        MetricsComponents<JavaClass> components = MetricsComponents.fromPackages(packages);


        //Métricas de dependência de componentes por Robert C. Martin https://www.archunit.org/userguide/html/000_Index.html#_component_dependency_metrics_by_robert_c_martin
        ComponentDependencyMetrics metrics = ArchitectureMetrics.componentDependencyMetrics(components);

        System.out.println("Robert C. Martin -------------------------- ");
        System.out.println("Ce: " + metrics.getEfferentCoupling(SUBPACKAGE));
        System.out.println("Ca: " + metrics.getAfferentCoupling(SUBPACKAGE));
        System.out.println("I: " + metrics.getInstability(SUBPACKAGE));
        System.out.println("A: " + metrics.getAbstractness(SUBPACKAGE));
        System.out.println("D: " + metrics.getNormalizedDistanceFromMainSequence(SUBPACKAGE));

        //Métricas de dependência cumulativa por John Lakos https://www.archunit.org/userguide/html/000_Index.html#_cumulative_dependency_metrics_by_john_lakos
        LakosMetrics lakosMetrics = ArchitectureMetrics.lakosMetrics(components);
        System.out.println("LakosMetrics -------------------------- ");
        System.out.println("CCD: " + lakosMetrics.getCumulativeComponentDependency());
        System.out.println("ACD: " + lakosMetrics.getAverageComponentDependency());
        System.out.println("RACD: " + lakosMetrics.getRelativeAverageComponentDependency());
        System.out.println("NCCD: " + lakosMetrics.getNormalizedCumulativeComponentDependency());

        //Métricas de visibilidade por Herbert Dowalil https://www.archunit.org/userguide/html/000_Index.html#_visibility_metrics_by_herbert_dowalil

        VisibilityMetrics visibilityMetrics = ArchitectureMetrics.visibilityMetrics(components);
        System.out.println("visibilidade por Herbert -------------------------- ");
        System.out.println("RV : " + visibilityMetrics.getRelativeVisibility(SUBPACKAGE));
        System.out.println("ARV: " + visibilityMetrics.getAverageRelativeVisibility());
        System.out.println("GRV: " + visibilityMetrics.getGlobalRelativeVisibility());


    }
}
