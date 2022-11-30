package com.censusanalyzer.main;

import com.opencsv.bean.CsvBindByName;

public class StateCensusAnalyzer {
    @CsvBindByName(column = "StateCode", required = true)
    private String stateCode;
    @CsvBindByName(column = "StateName", required = true)
    private String stateName;
    @CsvBindByName(column = "Population", required = true)
    private String population;
    @CsvBindByName(column = "Male", required = true)
    private String maleCount;
    @CsvBindByName(column = "Female", required = true)
    private String femaleCount;
    @CsvBindByName(column = "Literate", required = true)
    private String literateCount;
    @CsvBindByName(column = "Male_Literate", required = true)
    private String maleLiterate;
    @CsvBindByName(column = "Female_Literate", required = true)
    private String femaleLiterate;

    @Override
    public String toString() {
        return "StateCensusAnalyzer{" +
                "stateCode='" + stateCode + '\'' +
                ", stateName='" + stateName + '\'' +
                ", population='" + population + '\'' +
                ", maleCount='" + maleCount + '\'' +
                ", femaleCount='" + femaleCount + '\'' +
                ", literateCount='" + literateCount + '\'' +
                ", maleLiterate='" + maleLiterate + '\'' +
                ", femaleLiterate='" + femaleLiterate + '\'' +
                '}';
    }
}