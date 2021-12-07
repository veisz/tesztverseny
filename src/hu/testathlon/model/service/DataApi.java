package hu.testathlon.model.service;

import hu.testathlon.model.domain.TestResult;
import hu.testathlon.model.domain.TestValidator;

import java.util.List;

public class DataApi {


    private final DataParser dataParcer;
    private final List<String> lines;

    public DataApi( String filename, FileReader fileReader, DataParser dataParcer) {
        lines = fileReader.read(filename);
        this.dataParcer = dataParcer;
    }

    public List<TestResult> getTestResults() {
        return dataParcer.getResults(lines);
    }

    public String getAnwsers() {
        return dataParcer.getAnwsers(lines);
    }
}
