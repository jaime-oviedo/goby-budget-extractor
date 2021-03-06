/**
 * Copyright (c) 2017 Ingenium Software Ltda.
 */

package com.ingenium.goby.budget.extractor.extraction;

import com.ingenium.goby.budget.extractor.model.Assignment;
import com.ingenium.goby.budget.extractor.model.BudgetElementType;
import com.ingenium.goby.budget.extractor.model.BudgetHierarchyLevel;
import com.ingenium.goby.budget.extractor.model.ClassifiersCatalog;
import com.ingenium.goby.budget.extractor.model.CompositeBudgetElement;
import com.ingenium.goby.budget.extractor.model.Item;
import com.ingenium.goby.budget.extractor.model.Subtitle;
import com.opencsv.CSVReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.logging.Logger;

/** 
 * <!-- begin-UML-doc -->
 * <p>This class reads a csv file with the budget classifiers' information and generates an equivalent Json file.</p><p>@author JaimeRodrigo</p>
 * <!-- end-UML-doc -->
 * @author Jaime Oviedo
 * @uml.annotations
 *     derived_abstraction="platform:/resource/goby-design/budget-extractor.emx#_UXHY8EquEeeJsdrfgQXeQw"
 * @generated "sourceid:platform:/resource/goby-design/budget-extractor.emx#_UXHY8EquEeeJsdrfgQXeQw"
 */
public class ClassifiersCatalogExtractor {
  
  /** 
  * <!-- begin-UML-doc -->
  * <p>Represents a hierarchical catalog of budget elements.</p>
  * <!-- end-UML-doc -->
  * @author Jaime Oviedo
  * @uml.annotations
  *     derived_abstraction="platform:/resource/goby-design/budget-extractor.emx#_UXJ1MEquEeeJsdrfgQXeQw"
  * @generated "sourceid:platform:/resource/goby-design/budget-extractor.emx#_UXJ1MEquEeeJsdrfgQXeQw"
  */
  protected class ClassifiersCatalogImpl extends CompositeBudgetElement
      implements ClassifiersCatalog {
    /** 
    * <!-- begin-UML-doc -->
    * <p>Creates a new BudgetElementsCatalog.</p>
    * <!-- end-UML-doc -->
    * Creates a new instance of the class ClassifiersCatalogImpl.
    * @generated "sourceid:platform:/resource/goby-design/budget-extractor.emx#_Ud6kgEquEeeJsdrfgQXeQw"
    */
    public ClassifiersCatalogImpl() {
      // begin-user-code
      super(0, "Catalogo de clasificadores presupuestarios",
          "Estructura jerárquica de los clasificadores por objeto del gasto usados en el presupuesto",
          BudgetElementType.INSTITUTIONAL_CLASSIFICATION,
          BudgetHierarchyLevel.ROOT);
      
      // end-user-code
    }
    
    /** 
    * <!-- begin-UML-doc -->
    * <!-- end-UML-doc -->
    * @param subtitleNumber
    * @return
    * @generated "sourceid:platform:/resource/goby-design/budget-extractor.emx#_cLkIoFLxEeeyIrnvp3X3kA"
    */
    @Override
    public Subtitle getSubtitle(int subtitleNumber) {
      // begin-user-code
      return (Subtitle) super.getSubelement(subtitleNumber);
      // end-user-code
    }
    
    /** 
    * <!-- begin-UML-doc -->
    * <p>Gets all the subtitles in the catalog.</p>
    * <!-- end-UML-doc -->
    * @return <p>all the subtitles in the catalog</p>
    * @generated "sourceid:platform:/resource/goby-design/budget-extractor.emx#_UeEVgEquEeeJsdrfgQXeQw"
    */
    @SuppressWarnings("unchecked")
    @Override
    public Collection<Subtitle> getSubtitles() {
      // begin-user-code
      return (Collection<Subtitle>) super.getSubelements().values();
      // end-user-code
    }
  }
  
  /** 
  * <!-- begin-UML-doc -->
  * <!-- end-UML-doc -->
  * @generated "sourceid:platform:/resource/goby-design/budget-extractor.emx#_Uda1QEquEeeJsdrfgQXeQw"
  */
  private static final Logger log = Logger
      .getLogger("com.ingenium.goby.extractors.BudgetElementsExtractor");
  
  /** 
  * <!-- begin-UML-doc -->
  * <!-- end-UML-doc -->
  * @generated "sourceid:platform:/resource/goby-design/budget-extractor.emx#_LzWOoFk0EeeTxfHpmbMLyQ"
  */
  private final String source;
  
  /** 
  * <!-- begin-UML-doc -->
  * <p>Creates a new instance of a BudgetElementExtractor.</p>
  * <!-- end-UML-doc -->
  * Creates a new instance of the class ClassifiersCatalogExtractor.
  * @param source
  * @generated "sourceid:platform:/resource/goby-design/budget-extractor.emx#_UdnpkEquEeeJsdrfgQXeQw"
  */
  public ClassifiersCatalogExtractor(String source) {
    // begin-user-code
    super();
    this.source = source;
    // end-user-code
  }
  
  /*
   * (non-Javadoc)
   *
   * @see com.ingenium.goby.extractors.Extractor#extract()
   */
  /** 
  * <!-- begin-UML-doc -->
  * <!-- end-UML-doc -->
  * @return
  * @throws ExtractionException
  * @generated "sourceid:platform:/resource/goby-design/budget-extractor.emx#_UdpewEquEeeJsdrfgQXeQw"
  */
  
  public ClassifiersCatalog extract() throws ExtractionException {
    // begin-user-code
    FileInputStream fi = null;
    try {
      fi = new FileInputStream(source);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      throw new ExtractionException("Source file not found");
    }
    CSVReader reader = null;
    
    ClassifiersCatalogImpl catalog = new ClassifiersCatalogImpl();
    try {
      String line[] = null;
      reader = new CSVReader(new InputStreamReader(fi, "UTF-8"), ';', '"', 0);
      while ((line = reader.readNext()) != null) {
        
        int subtitleNumber = 0;
        
        String s = line[0];
        try {
          if (s != null) {
            subtitleNumber = Integer.parseInt(s);
          }
        } catch (Exception e) {
          throw new ExtractionException("Unable to extract subtitle number.");
        }
        
        int itemNumber = 0;
        s = line[1];
        if ((s != null) && !"".equals(s)) {
          try {
            itemNumber = Integer.parseInt(s);
          } catch (NumberFormatException e) {
            ClassifiersCatalogExtractor.log
                .finest("Unable to extract item number.");
          }
        } else {
          itemNumber = 0;
        }
        
        int assignmentNumber = 0;
        s = line[2];
        if ((s != null) && !"".equals(s)) {
          try {
            assignmentNumber = Integer.parseInt(s);
          } catch (NumberFormatException e) {
            ClassifiersCatalogExtractor.log
                .finest("Unable to extract assignment number.");
          }
        }
        
        String name = "";
        s = line[3];
        if (s != null) {
          name = s;
        } else {
          throw new ExtractionException(
              new StringBuilder("Unable to obtain name for element:")
                  .append(subtitleNumber).append(itemNumber)
                  .append(assignmentNumber).toString());
        }
        String description = "";
        s = line[4];
        if (s != null) {
          description = s;
        } else {
          description = "";
        }
        
        Subtitle subtitle = catalog.getSubtitle(subtitleNumber);
        if (assignmentNumber != 0) {
          if (subtitle != null) {
            subtitle.addAssignment(itemNumber,
                new Assignment(assignmentNumber, name, description,
                    BudgetElementType.INSTITUTIONAL_CLASSIFICATION));
            continue;
          }
        }
        
        if (itemNumber != 0) {
          if (subtitle != null) {
            subtitle.addItem(new Item(itemNumber, name, description,
                BudgetElementType.INSTITUTIONAL_CLASSIFICATION));
            continue;
          }
        }
        
        if (subtitleNumber != 0) {
          subtitle = new Subtitle(subtitleNumber, name, description,
              BudgetElementType.INSTITUTIONAL_CLASSIFICATION);
          catalog.addSubelement(subtitle);
          continue;
        }
        
        throw new ExtractionException(
            "Malformed csv file, found budgetary items (chapter or program) without previously created parent");
        
      }
      
      reader.close();
    } catch (IOException e) {
      throw new ExtractionException(
          "Unable to create input stream or csv reader");
    } finally {
      try {
        if (reader != null) {
          reader.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        fi.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    
    return catalog;
    // end-user-code
  }
  
}