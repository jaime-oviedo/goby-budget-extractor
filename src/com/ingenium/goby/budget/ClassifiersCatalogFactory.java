/**
 * Copyright (c) 2017 Ingenium Software Ltda.
 */

package com.ingenium.goby.budget;

import com.ingenium.goby.budget.extraction.ClassifiersCatalogExtractor;
import com.ingenium.goby.extractors.DownloadException;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author JaimeRodrigo
 * @uml.annotations
 *     derived_abstraction="platform:/resource/goby-design/goby-classifier-extractor.emx#_A8MkQFH0Eee-AoOzRlyylA"
 * @generated "sourceid:platform:/resource/goby-design/goby-classifier-extractor.emx#_A8MkQFH0Eee-AoOzRlyylA"
 */
public class ClassifiersCatalogFactory {
  /** 
  * <!-- begin-UML-doc -->
  * <!-- end-UML-doc -->
  * @generated "sourceid:platform:/resource/goby-design/goby-classifier-extractor.emx#_3r-EQFLeEeeyIrnvp3X3kA"
  */
  private static ClassifiersCatalogFactory instance;
  /** 
  * <!-- begin-UML-doc -->
  * <!-- end-UML-doc -->
  * @generated "sourceid:platform:/resource/goby-design/goby-classifier-extractor.emx#_meeoEFLfEeeyIrnvp3X3kA"
  */
  private ClassifiersCatalog classifiersCatalog;
  
  /** 
  * <!-- begin-UML-doc -->
  * <!-- end-UML-doc -->
  * @generated "sourceid:platform:/resource/goby-design/goby-classifier-extractor.emx#_EhlrYFNZEeeyIrnvp3X3kA"
  */
  private boolean extract = false;
  
  /** 
  * <!-- begin-UML-doc -->
  * <!-- end-UML-doc -->
  * @return
  * @generated "sourceid:platform:/resource/goby-design/goby-classifier-extractor.emx#_KwtEAFLgEeeyIrnvp3X3kA"
  */
  public static ClassifiersCatalogFactory getInstance() {
    // begin-user-code
    if (ClassifiersCatalogFactory.instance == null) {
      ClassifiersCatalogFactory.instance = new ClassifiersCatalogFactory();
    }
    return ClassifiersCatalogFactory.instance;
    // end-user-code
  }
  
  /** 
  * <!-- begin-UML-doc -->
  * <!-- end-UML-doc -->
  * @return
  * @generated "sourceid:platform:/resource/goby-design/goby-classifier-extractor.emx#_NkT0EFLgEeeyIrnvp3X3kA"
  */
  public ClassifiersCatalog getClassifiersCatalog() {
    // begin-user-code
    if (extract) {
      ClassifiersCatalogExtractor extractor = new ClassifiersCatalogExtractor();
      try {
        extractor.download();
      } catch (DownloadException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      classifiersCatalog = extractor.getExtractedCatalog();
      extract = false;
    }
    return classifiersCatalog;
    // end-user-code
  }
  
  /** 
  * <!-- begin-UML-doc -->
  * <!-- end-UML-doc -->
  * @param forceExtraction
  * @return
  * @generated "sourceid:platform:/resource/goby-design/goby-classifier-extractor.emx#_IZ718FNZEeeyIrnvp3X3kA"
  */
  public ClassifiersCatalog getClassifiersCatalog(boolean forceExtraction) {
    // begin-user-code
    extract = forceExtraction;
    return getClassifiersCatalog();
    
    // end-user-code
  }
  
  /** 
  * <!-- begin-UML-doc -->
  * <!-- end-UML-doc -->
  * Crea una nueva instancia de la clase ClassifiersCatalogFactory.
  * @generated "sourceid:platform:/resource/goby-design/goby-classifier-extractor.emx#_GeRTIFNcEeeyIrnvp3X3kA"
  */
  private ClassifiersCatalogFactory() {
    // begin-user-code
    super();
    // end-user-code
  }
}