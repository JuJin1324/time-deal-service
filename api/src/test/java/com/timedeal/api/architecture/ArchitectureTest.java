package com.timedeal.api.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.onionArchitecture;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

@AnalyzeClasses(packages = "com.timedeal", importOptions = ImportOption.DoNotIncludeTests.class)
public class ArchitectureTest {

    @ArchTest
    static final ArchRule hexagonal_architecture_must_be_respected = onionArchitecture()
        .domainModels("..domain..")
        .domainServices("..application.service..")
        .applicationServices("..application.port..")
        .adapter("web", "..adapter.in.web..")
        .adapter("persistence", "..adapter.out.persistence..")
        .withOptionalLayers(true);

    @ArchTest
    static final ArchRule no_cycles_allowed = slices()
        .matching("com.timedeal.(*)..")
        .should().beFreeOfCycles();
}
