package com.quality.collab.poc.datatable.annoprocessors;

import com.quality.collab.poc.datatable.annotations.actions.viewdropdown.ViewDropdownAction;
import com.quality.collab.poc.datatable.annotations.DataTable;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

@SupportedAnnotationTypes("com.quality.collab.poc.datatable.annotations.actions.AdvancedSearch")
@SupportedSourceVersion(SourceVersion.RELEASE_17) // Or your Java version
public class AdvancedSearchProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(ViewDropdownAction.class)) {
            if (!element.getAnnotationMirrors().stream()
                    .anyMatch(a -> a.getAnnotationType().toString().equals(DataTable.class.getName()))) {
                processingEnv.getMessager().printMessage(
                        Diagnostic.Kind.ERROR,
                        "@AdvancedSearch requires @DataTable to also be present.",
                        element
                );
            }
        }
        return true;
    }
}

