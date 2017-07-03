/**
 * Copyright (c) 2017 Ingenium Software Ltda.
 */

package com.ingenium.goby.budget.extractor;

import com.ingenium.goby.budget.extractor.elements.BudgetElementType;
import com.ingenium.goby.budget.extractor.elements.BudgetHierarchyLevel;
import com.ingenium.goby.budget.extractor.elements.CompositeBudgetElement;
import com.ingenium.goby.budget.extractor.extraction.map.BudgetElementToJsonMapper;
import com.ingenium.goby.budget.extractor.injection.FileSystemInjector;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Conjunto de pruebas para la clase BudgetElementsExtractor.
 *
 * @author JaimeRodrigo
 */
public class ClassifiersCatalogFactoryTest {

  /**
   * Tests the correct extraction of a json budget classifier catalog from a csv.
   */
  @Test
  public final void testExtractClasificadores() {
    String s = File.separator;
    String source = new StringBuffer("test").append(s).append("com").append(s)
        .append("ingenium").append(s).append("goby").append(s).append("budget")
        .append(s).append("extractor").append(s).append("fixture").append(s)
        .append("classifiers.csv").toString();

    ClassifiersCatalogFactory factory = ClassifiersCatalogFactory.getInstance();
    factory.setSource(source);
    ClassifiersCatalog catalog = factory.getClassifiersCatalog(true);

    CompositeBudgetElement b = new CompositeBudgetElement(0,
        "Catalogo de clasificadores presupuestarios",
        "Estructura jerárquica de los clasificadores por objeto del gasto usados en el presupuesto",
        BudgetElementType.BUDGETARY_CLASSIFICATION, BudgetHierarchyLevel.ROOT);
    b.setSubelements(catalog.getSubtitles());

    String jsonCatalog = BudgetElementToJsonMapper.map(b, 0);
    String destination = "tmp" + s + "classifiers.json";
    FileSystemInjector fsi = new FileSystemInjector(destination, jsonCatalog);
    try {
      fsi.inject();
      File file1 = new File(destination);
      String objective = new StringBuffer("test").append(s).append("com")
          .append(s).append("ingenium").append(s).append("goby").append(s)
          .append("budget").append(s).append("extractor").append(s)
          .append("fixture").append(s).append("classifiers.json").toString();
      File file2 = new File(objective);
      Assert.assertTrue(FileUtils.contentEquals(file1, file2));
    } catch (Exception e) {
      Assert.fail("Injection failed or unexpected extracted file contents.");
      e.printStackTrace();
    }

  }
}
