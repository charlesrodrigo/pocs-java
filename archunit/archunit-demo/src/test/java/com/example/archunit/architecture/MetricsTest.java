package com.example.archunit.architecture;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.domain.JavaPackage;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchIgnore;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.library.metrics.*;

import java.util.Set;


@AnalyzeClasses(packages = "com.example", importOptions = ImportOption.DoNotIncludeTests.class)
public class MetricsTest {

    private static String PACKAGE = "com.example";
    private static String SUBPACKAGE = PACKAGE + ".archunit";

    @ArchIgnore
    @ArchTest
    public void metrics(JavaClasses classes) {
        Set<JavaPackage> packages = classes.getPackage(PACKAGE).getSubpackages();

        // These components can also be created in a package agnostic way, compare MetricsComponents.from(..)
        MetricsComponents<JavaClass> components = MetricsComponents.fromPackages(packages);


        //Métricas de dependência de componentes por Robert C. Martin https://www.archunit.org/userguide/html/000_Index.html#_component_dependency_metrics_by_robert_c_martin
        ComponentDependencyMetrics metrics = ArchitectureMetrics.componentDependencyMetrics(components);
        System.out.println("Robert C. Martin -------------------------- ");

        //Dependências que chegam. Essa métrica identifica o número de classes fora desse componente que dependem das classes contida nele
        System.out.println("Fan-in (Ca): " + metrics.getAfferentCoupling(SUBPACKAGE));

        //Dependências que saem. Essa metrica identifica o número de classes contidas nesse componente que dependem de classes fora dele
        System.out.println("Fan-out(CE): " + metrics.getEfferentCoupling(SUBPACKAGE));
        // Essa metrica tem a variação [0,1]
        // I=0 indica um componente com estabilidade maxima
        // I=1 indica um componente com instabilidade maxima
        System.out.println("Instabilidade: " + metrics.getInstability(SUBPACKAGE));
        // Principio de abstrações estáveis
        // Abstractness é uma medita de nivel de abstracao de um componente.
        // Seu valor corresponde á razão entre as interfaces e classes abstratas de um componente
        // e o número total de de classes desse mesmo componente
        // varia de 0 a 1
        // Valor 0 indica o componente não tem nenhuma classe abstrata
        // Valor 1 indica que o componente só contém classe abstrata
        System.out.println("A: " + metrics.getAbstractness(SUBPACKAGE));

        //Metrica que mede o quanto os componentes estão proximos da sequencia Principal ou proximo dela
        // Valor 0: Indica que o componente está diretamente na sequencia principal
        // Valor 1 Indica que o componente está o mais longe possivel da sequencia principal
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
        System.out.println("Herbert -------------------------- ");
        System.out.println("RV : " + visibilityMetrics.getRelativeVisibility(SUBPACKAGE));
        System.out.println("ARV: " + visibilityMetrics.getAverageRelativeVisibility());
        System.out.println("GRV: " + visibilityMetrics.getGlobalRelativeVisibility());


    }
}
