package com.ingenium.goby.budget;

import com.ingenium.goby.budget.extractor.extraction.BudgetLawCsvFilesDownloaderTest;
import com.ingenium.goby.budget.extractor.extraction.BudgetLawCsvFilesListExtractorTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ClassifiersCatalogFactoryTest.class,
    BudgetLawCsvFilesListDownloaderTest.class,
    BudgetLawCsvFilesDownloaderTest.class })
public class AllTests {

}