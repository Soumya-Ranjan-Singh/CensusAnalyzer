package com.censusanalyzer.main;


public class CensusAnalyserException extends Exception {
    public enum ExceptionType {
        CENSUS_FILE_PROBLEM,WRONG_FILE_TYPE,WRONG_HEADER,WRONG_DELIMITER
    }

    public ExceptionType type;

    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
        if (type.equals(ExceptionType.CENSUS_FILE_PROBLEM))
        {
            System.out.println("Wrong File Path");
        } else if (type.equals(ExceptionType.WRONG_FILE_TYPE)) {
            System.out.println("Wrong File Type");
        }else if (type.equals(ExceptionType.WRONG_HEADER)) {
            System.out.println("CSV File containing header doesn't match with the program");
        }else if (type.equals(ExceptionType.WRONG_DELIMITER)) {
            System.out.println("CSV File contains wrong delimiter");
        }
    }
}
