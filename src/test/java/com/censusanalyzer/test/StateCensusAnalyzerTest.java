package com.censusanalyzer.test;

import com.censusanalyzer.main.CSVStatesCensus;
import com.censusanalyzer.main.CensusAnalyserException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import static com.censusanalyzer.main.CensusAnalyserException.ExceptionType.*;

public class StateCensusAnalyzerTest {
    private static final String Actual_CSV_FILE_PATH = "./src/StateWiseLiteracy.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/StateWiseLiteracy.csv";
    private static final String Actual_FILE_PATH_WITH_WRONG_FILETYPE = "./src/StateWiseLiteracy.pdf";
    private static final String FILE_PATH_WITH_CSV_DELIMITER = "./src/StateWiseLiteracyWrongDeli.csv";
    private static final String FILE_PATH_WITH_WRONG_CSV_Header = "./src/StateWiseLiteracyWrongHead.csv";

    @Test
    public void givenIndianCensusCSVFileReturnsCorrectRecords() {
        try {
            CSVStatesCensus censusAnalyser = new CSVStatesCensus();
            int numOfRecords = censusAnalyser.readData(Actual_CSV_FILE_PATH,CENSUS_FILE_PROBLEM);
            Assertions.assertEquals(20, numOfRecords);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
        try {
            CSVStatesCensus censusAnalyser = new CSVStatesCensus();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.readData(WRONG_CSV_FILE_PATH,CENSUS_FILE_PROBLEM);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIndianCensusCSVFileReturnsInCorrectRecords() {
        CSVStatesCensus censusAnalyzer = new CSVStatesCensus();
        try {
            int numOfRecord = censusAnalyzer.readData(Actual_CSV_FILE_PATH,CENSUS_FILE_PROBLEM);
            Assertions.assertNotEquals(30, numOfRecord);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIndianCensusCSVFileReturnsIncorrectFileType_But_PathShouldBeCorrect() {
        CSVStatesCensus censusAnalyzer = new CSVStatesCensus();
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyzer.readData(Actual_FILE_PATH_WITH_WRONG_FILETYPE, WRONG_FILE_TYPE);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(WRONG_FILE_TYPE, e.type);
        }
    }

    @Test
    public void givenIndianCensusCSVFileReturnsIncorrectDelimiter() {
        CSVStatesCensus censusAnalyzer = new CSVStatesCensus();
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyzer.readData(FILE_PATH_WITH_CSV_DELIMITER,WRONG_DELIMITER);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(WRONG_DELIMITER, e.type);
        }
    }

    @Test
    public void givenIndianCensusCSVFileHaveIncorrectHeader() {
        CSVStatesCensus censusAnalyzer = new CSVStatesCensus();
        try {
            censusAnalyzer.readData(FILE_PATH_WITH_WRONG_CSV_Header,WRONG_HEADER);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals("Error capturing CSV header!", e.getMessage());

        }
    }
}
