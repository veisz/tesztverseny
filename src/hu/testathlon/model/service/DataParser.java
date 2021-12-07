package hu.testathlon.model.service;

import hu.testathlon.model.domain.TestResult;
import hu.testathlon.model.domain.TestValidator;

import java.util.List;
import java.util.stream.Collectors;

public class DataParser {

    public String getAnwsers(List<String> lines) {
        return (lines.get(0));
    }

    public List<TestResult> getResults(List<String> lines) {
        return lines.stream()
                .skip(1)
                .map(this::createTestResult)
                .collect(Collectors.toList());
    }

    private TestResult createTestResult(String line) {
        String[] itmes = line.split(" ");
        return new TestResult(itmes[0], itmes[1]);
    }
}
