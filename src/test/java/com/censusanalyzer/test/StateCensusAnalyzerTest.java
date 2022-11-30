package com.censusanalyzer.test;

import com.censusanalyzer.main.CSVStatesCensus;
import com.censusanalyzer.main.CensusAnalyserException;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;

public class StateCensusAnalyzerTest {
    private static final String Actual_CSV_FILE_PATH = "./src/StateWiseLiteracy.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/StateWiseLiteracy.csv";

    @Test
    public void givenIndianCensusCSVFileReturnsCorrectRecords() {
        try {
            CSVStatesCensus censusAnalyser = new CSVStatesCensus();
            int numOfRecords = censusAnalyser.readData(Actual_CSV_FILE_PATH);
            assertEquals(20,numOfRecords);
        } catch (CensusAnalyserException e) { }
    }

    @Test
    public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
        try {
            CSVStatesCensus censusAnalyser = new CSVStatesCensus();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.readData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }
}
