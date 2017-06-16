/**
 *
 */

package com.ingenium.goby.budget.extraction;

import com.ingenium.goby.budget.extraction.download.BudgetLawCsvFilesDownloader;
import com.ingenium.goby.budget.extraction.download.BudgetLawWebPageDownloader;
import com.ingenium.goby.extractors.ExtractionException;
import com.ingenium.goby.extractors.ExtractorImpl;

/**
 * <!-- begin-UML-doc -->
 * Esta&nbsp;clase&nbsp;extrae&nbsp;toda&nbsp;la&nbsp;Ley&nbsp;de&nbsp;Presupuestos&nbsp;desde&nbsp;el&nbsp;sitio&nbsp;de&nbsp;la&nbsp;DIPRES.<br>
 * <br>
 * 
 * @author&nbsp;JaimeRodrigo <!-- end-UML-doc -->
 * 
 * @author joviedo
 * @uml.annotations derived_abstraction="platform:/resource/goby-design/goby-classifier-extractor.emx#_UautoEquEeeJsdrfgQXeQw"
 * @generated "sourceid:platform:/resource/goby-design/goby-classifier-extractor.emx#_UautoEquEeeJsdrfgQXeQw"
 */
public class BudgetLawExtractor extends ExtractorImpl {

  /**
   * <!-- begin-UML-doc --> <!-- end-UML-doc -->
   * 
   * @generated "sourceid:platform:/resource/goby-design/goby-classifier-extractor.emx#_UjBG8EquEeeJsdrfgQXeQw"
   */
  private final BudgetLawWebPageDownloader dpe;
  /**
   * <!-- begin-UML-doc --> <!-- end-UML-doc -->
   * 
   * @generated "sourceid:platform:/resource/goby-design/goby-classifier-extractor.emx#_UjCVEEquEeeJsdrfgQXeQw"
   */
  private final BudgetLawCsvFilesListExtractor bfle;
  /**
   * <!-- begin-UML-doc --> <!-- end-UML-doc -->
   * 
   * @generated "sourceid:platform:/resource/goby-design/goby-classifier-extractor.emx#_UjDjMEquEeeJsdrfgQXeQw"
   */
  private final BudgetLawCsvFilesDownloader bfe;

  /**
   * <!-- begin-UML-doc -->
   * Crea&nbsp;una&nbsp;nueva&nbsp;instancia&nbsp;de&nbsp;la&nbsp;clase&nbsp;BudgetLawExtractor.
   * <!-- end-UML-doc -->
   * 
   * @generated "sourceid:platform:/resource/goby-design/goby-classifier-extractor.emx#_UjFYYEquEeeJsdrfgQXeQw"
   */
  public BudgetLawExtractor() {
    // begin-user-code
    dpe = new BudgetLawWebPageDownloader();
    bfle = new BudgetLawCsvFilesListExtractor();
    bfe = new BudgetLawCsvFilesDownloader();
    // end-user-code
  }

  /*
   * (non-Javadoc)
   *
   * @see com.ingenium.goby.extractors.Extractor#extract()
   */
  /**
   * <!-- begin-UML-doc --> <!-- end-UML-doc -->
   * 
   * @throws ExtractionException
   * @generated "sourceid:platform:/resource/goby-design/goby-classifier-extractor.emx#_UjH0oEquEeeJsdrfgQXeQw"
   */
  @Override
  public void extract() throws ExtractionException {
    // begin-user-code
    dpe.extract();
    bfle.extract();
    bfe.extract();
    // end-user-code
  }

}
