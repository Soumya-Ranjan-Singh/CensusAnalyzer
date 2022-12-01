package com.censusanalyzer.main;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.censusanalyzer.main.CensusAnalyserException.ExceptionType;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class CSVStatesCensus {

    public int readData(String csvFilePath,ExceptionType type) throws CensusAnalyserException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            Iterator<StateCensusAnalyzer> censusCSVIterator = getCSVIterator(reader, StateCensusAnalyzer.class);
            return getCount(censusCSVIterator);
        } catch (Exception e) {
            throw new CensusAnalyserException(e.getMessage(), type);
        }
    }

    //generic method
    private <E> Iterator getCSVIterator(Reader reader, Class csvClass) {
        CsvToBeanBuilder<E> csvCsvToBeanBuilder = new CsvToBeanBuilder<>(reader);
        csvCsvToBeanBuilder.withType(csvClass);
        csvCsvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
        CsvToBean<E> csvToBean = csvCsvToBeanBuilder.build();
        return csvToBean.iterator();
    }

    //generic method for count entries
    private <E> int getCount(Iterator<E> censusCSVIterator) {
        Iterable<E> csvIterator = () -> censusCSVIterator;
        int numOfEntries = (int) StreamSupport.stream(csvIterator.spliterator(), true).count();
        return numOfEntries;
    }
}
