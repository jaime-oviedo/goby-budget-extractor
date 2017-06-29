/**
 *
 */

package com.ingenium.goby.budget.extraction;

import com.ingenium.goby.budget.BudgetLaw;
import com.ingenium.goby.budget.ClassifiersCatalog;
import com.ingenium.goby.budget.ClassifiersCatalogFactory;
import com.ingenium.goby.budget.InstitutionsCatalog;
import com.ingenium.goby.budget.InstitutionsCatalogFactory;
import com.ingenium.goby.budget.elements.Assignment;
import com.ingenium.goby.budget.elements.Batch;
import com.ingenium.goby.budget.elements.BudgetElementType;
import com.ingenium.goby.budget.elements.BudgetHierarchyLevel;
import com.ingenium.goby.budget.elements.Chapter;
import com.ingenium.goby.budget.elements.CompositeBudgetElement;
import com.ingenium.goby.budget.elements.Item;
import com.ingenium.goby.budget.elements.Program;
import com.ingenium.goby.budget.elements.Subtitle;
import com.opencsv.CSVReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Collection;
import java.util.logging.Logger;

/** 
 * <!-- begin-UML-doc -->
 * Esta&nbsp;clase&nbsp;extrae&nbsp;toda&nbsp;la&nbsp;Ley&nbsp;de&nbsp;Presupuestos&nbsp;desde&nbsp;el&nbsp;sitio&nbsp;de&nbsp;la&nbsp;DIPRES.<br><br>@author&nbsp;JaimeRodrigo
 * <!-- end-UML-doc -->
 * @author JaimeRodrigo
 * @uml.annotations
 *     derived_abstraction="platform:/resource/goby-design/goby-classifier-extractor.emx#_UautoEquEeeJsdrfgQXeQw"
 * @generated "sourceid:platform:/resource/goby-design/goby-classifier-extractor.emx#_UautoEquEeeJsdrfgQXeQw"
 */
public class BudgetLawExtractor {
  
  /** 
  * <!-- begin-UML-doc -->
  * <!-- end-UML-doc -->
  * @author JaimeRodrigo
  * @uml.annotations
  *     derived_abstraction="platform:/resource/goby-design/goby-classifier-extractor.emx#_lSO08FhREeeLhanfOp3nJA"
  * @generated "sourceid:platform:/resource/goby-design/goby-classifier-extractor.emx#_lSO08FhREeeLhanfOp3nJA"
  */
  public class BudgetLawImpl extends CompositeBudgetElement
      implements BudgetLaw {
    
    /** 
    * <!-- begin-UML-doc -->
    * <!-- end-UML-doc -->
    * @param batchNumber
    * @return
    * @generated "sourceid:platform:/resource/goby-design/goby-classifier-extractor.emx#_CXBu8FhUEeeLhanfOp3nJA"
    */
    @Override
    public Batch getBatch(int batchNumber) {
      // begin-user-code
      return (Batch) getSubelement(batchNumber);
      // end-user-code
    }
    
    /** 
    * <!-- begin-UML-doc -->
    * <!-- end-UML-doc -->
    * Crea una nueva instancia de la clase BudgetLawImpl.
    * @generated "sourceid:platform:/resource/goby-design/goby-classifier-extractor.emx#_KnOqkFhUEeeLhanfOp3nJA"
    */
    public BudgetLawImpl() {
      // begin-user-code
      super(0, "Ley de Presupuesto", "", BudgetElementType.NONE,
          BudgetHierarchyLevel.ROOT);
      // end-user-code
    }
    
    /** 
    * <!-- begin-UML-doc -->
    * <!-- end-UML-doc -->
    * @return
    * @generated "sourceid:platform:/resource/goby-design/goby-classifier-extractor.emx#_CXBH4FhUEeeLhanfOp3nJA"
    */
    @SuppressWarnings("unchecked")
    @Override
    public Collection<Batch> getBatches() {
      // begin-user-code
      return (Collection<Batch>) getSubelements().values();
      // end-user-code
    }
  }
  
  /** 
  * <!-- begin-UML-doc -->
  * <!-- end-UML-doc -->
  * @generated "sourceid:platform:/resource/goby-design/goby-classifier-extractor.emx#_wErB4FejEeeJT_eFoT-0rA"
  */
  private static final Logger log = Logger
      .getLogger("com.ingenium.goby.extractors.BudgetLawExtractor");
  
  /** 
  * <!-- begin-UML-doc -->
  * <!-- end-UML-doc -->
  * @generated "sourceid:platform:/resource/goby-design/goby-classifier-extractor.emx#_Mqu6wFhREeeLhanfOp3nJA"
  */
  private final String source;
  
  /** 
  * <!-- begin-UML-doc -->
  * Crea&nbsp;una&nbsp;nueva&nbsp;instancia&nbsp;de&nbsp;la&nbsp;clase&nbsp;BudgetLawExtractor.
  * <!-- end-UML-doc -->
  * Crea una nueva instancia de la clase BudgetLawExtractor.
  * @param source
  * @generated "sourceid:platform:/resource/goby-design/goby-classifier-extractor.emx#_UjFYYEquEeeJsdrfgQXeQw"
  */
  public BudgetLawExtractor(String source) {
    // begin-user-code
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
  * @generated "sourceid:platform:/resource/goby-design/goby-classifier-extractor.emx#_UjH0oEquEeeJsdrfgQXeQw"
  */
  public BudgetLaw extract() throws ExtractionException {
    // begin-user-code
    FileInputStream fi = null;
    try {
      fi = new FileInputStream(source);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      throw new ExtractionException("Source file not found");
    }
    CSVReader reader = null;
    
    BudgetLawImpl law = new BudgetLawImpl();
    try {
      String line[] = null;
      reader = new CSVReader(new InputStreamReader(fi, "UTF-8"), ';', '"', 1);
      while ((line = reader.readNext()) != null) {
        
        int batchNumber = 0;
        
        String s = line[0];
        try {
          if (s != null) {
            batchNumber = Integer.parseInt(s);
          }
        } catch (Exception e) {
          throw new ExtractionException("Unable to extract batch number.");
        }
        
        int chapterNumber = 0;
        s = line[1];
        if (s != null) {
          try {
            chapterNumber = Integer.parseInt(s);
          } catch (NumberFormatException e) {
            BudgetLawExtractor.log.finest("Unable to extract chatper number.");
          }
        } else {
          chapterNumber = 0;
        }
        
        int programNumber = 0;
        s = line[2];
        if (s != null) {
          try {
            programNumber = Integer.parseInt(s);
          } catch (NumberFormatException e) {
            BudgetLawExtractor.log.finest("Unable to extact program number.");
          }
        }
        
        int subtitleNumber = 0;
        s = line[3];
        if (s != null) {
          try {
            subtitleNumber = Integer.parseInt(s);
          } catch (NumberFormatException e) {
            BudgetLawExtractor.log.finest("Unable to extact program number.");
          }
        }
        
        int itemNumber = 0;
        s = line[4];
        if (s != null) {
          try {
            itemNumber = Integer.parseInt(s);
          } catch (NumberFormatException e) {
            BudgetLawExtractor.log.finest("Unable to extact program number.");
          }
        }
        
        int assignmentNumber = 0;
        s = line[5];
        if (s != null) {
          try {
            assignmentNumber = Integer.parseInt(s);
          } catch (NumberFormatException e) {
            BudgetLawExtractor.log.finest("Unable to extact program number.");
          }
        }
        
        String name = "";
        s = line[6];
        if (s != null) {
          name = s;
        } else {
          throw new ExtractionException(
              new StringBuffer("Unable to obtain name for element:")
                  .append(batchNumber).append(",").append(chapterNumber)
                  .append(",").append(programNumber).toString());
        }
        
        BigInteger budgetNumber = BigInteger.ZERO;
        s = line[7];
        if (s != null) {
          budgetNumber = BigInteger.valueOf(Long.valueOf(s));
        }
        
        BigInteger dollarBudgetNumber = BigInteger.ZERO;
        s = line[8];
        if (s != null) {
          dollarBudgetNumber = BigInteger.valueOf(Long.valueOf(s));
        }
        
        ClassifiersCatalog cc = ClassifiersCatalogFactory.getInstance()
            .getClassifiersCatalog();
        InstitutionsCatalog ic = InstitutionsCatalogFactory.getInstance()
            .getInstitutionsCatalog();
        
        Batch catBatch = ic.getBatch(batchNumber);
        Chapter catChapter = catBatch.getChapter(chapterNumber);
        Program catProgram = catChapter.getProgram(programNumber);
        Subtitle catSubtitle = cc.getSubtitle(subtitleNumber);
        
        if ((catBatch == null) || (catChapter == null) || (catProgram == null)
            || (catSubtitle == null)) {
          throw new ExtractionException(
              "Malformed input file. Can't find batch, chapter, program or subtitle in tuple ("
                  + batchNumber + "," + chapterNumber + "," + programNumber
                  + "," + subtitleNumber + ")");
        }
        
        if ((itemNumber == 0) && (assignmentNumber != 0)) {
          throw new ExtractionException(
              "Malformed input file. Received assignment " + assignmentNumber
                  + " with no item number. See budget row (" + batchNumber + ","
                  + chapterNumber + "," + programNumber + "," + subtitleNumber
                  + ")");
        }
        
        // No malformed entry, let's create the tree structure as needed
        
        Batch lawBatch = law.getBatch(batchNumber);
        if (lawBatch == null) {
          lawBatch = new Batch(catBatch.getNumber(), catBatch.getName(),
              catBatch.getDescription(), BudgetElementType.BUDGET);
          law.addSubelement(lawBatch);
        }
        
        Chapter lawChapter = lawBatch.getChapter(chapterNumber);
        if (lawChapter == null) {
          lawChapter = new Chapter(catChapter.getNumber(), catChapter.getName(),
              catChapter.getDescription(), BudgetElementType.BUDGET);
          lawBatch.addChapter(lawChapter);
        }
        
        Program lawProgram = lawChapter.getProgram(programNumber);
        if (lawProgram == null) {
          lawProgram = new Program(catProgram.getNumber(), catProgram.getName(),
              catProgram.getDescription(), BudgetElementType.BUDGET);
          lawChapter.addProgram(lawProgram);
        }
        
        Subtitle lawSubtitle = lawProgram.getSubtitle(subtitleNumber);
        if (lawSubtitle == null) {
          lawSubtitle = new Subtitle(catSubtitle.getNumber(),
              catSubtitle.getName(), catSubtitle.getDescription(),
              BudgetElementType.BUDGET);
          lawProgram.addSubtitle(lawSubtitle);
        }
        
        if (itemNumber == 0) {
          lawSubtitle.setInitialBudget(budgetNumber);
          lawSubtitle.setActualBudget(budgetNumber);
          lawSubtitle.setInitialDollarBudget(dollarBudgetNumber);
          lawSubtitle.setActualDollarBudget(dollarBudgetNumber);
          continue;
        }
        
        Item lawItem = lawSubtitle.getItem(subtitleNumber);
        Item catItem = catSubtitle.getItem(itemNumber);
        if (lawItem == null) {
          lawItem = new Item(catItem.getNumber(), name,
              catItem.getDescription(), BudgetElementType.BUDGET);
          String catItemName = catItem.getName();
          if (!name.equals(catItemName)) {
            BudgetLawExtractor.log.fine("Name read from budget file:" + name
                + " differs from name found in classifiers catalog:"
                + catItemName + ". Using budget file name.");
          }
          lawSubtitle.addItem(lawItem);
        }
        
        if (assignmentNumber == 0) {
          lawItem.setInitialBudget(budgetNumber);
          lawItem.setActualBudget(budgetNumber);
          lawItem.setInitialDollarBudget(dollarBudgetNumber);
          lawItem.setActualDollarBudget(dollarBudgetNumber);
          continue;
        }
        
        Assignment catAssignment = catItem.getAssignment(assignmentNumber);
        Assignment lawAssignment = new Assignment(catAssignment.getNumber(),
            name, catAssignment.getDescription(), BudgetElementType.BUDGET);
        String catAssignmentName = catAssignment.getName();
        if (!name.equals(catAssignmentName)) {
          
          BudgetLawExtractor.log.fine("Name read from budget file:" + name
              + " differs from name found in classifiers catalog:"
              + catAssignmentName + ". Using budget file name.");
        }
        lawAssignment.setInitialBudget(budgetNumber);
        lawAssignment.setActualBudget(budgetNumber);
        lawAssignment.setInitialDollarBudget(dollarBudgetNumber);
        lawAssignment.setActualDollarBudget(dollarBudgetNumber);
        lawItem.addAssignment(lawAssignment);
        
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
    
    return law;
    // end-user-code
  }
  
}
