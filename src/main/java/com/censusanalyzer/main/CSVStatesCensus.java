package com.censusanalyzer.main;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import com.censusanalyzer.main.CensusAnalyserException.ExceptionType;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class CSVStatesCensus {

    public int readData(String csvFilePath,ExceptionType type) throws CensusAnalyserException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBeanBuilder<StateCensusAnalyzer> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(StateCensusAnalyzer.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<StateCensusAnalyzer> csvToBean = csvToBeanBuilder.build();
            Iterator<StateCensusAnalyzer> censusCSVIterator = csvToBean.iterator();
            int namOfEateries = 0;
            while (censusCSVIterator.hasNext()) {
                namOfEateries++;
                StateCensusAnalyzer censusData = censusCSVIterator.next();
            }
            return namOfEateries;
        } catch (Exception e) {
            throw new CensusAnalyserException(e.getMessage(), type);
        }
    }
}
