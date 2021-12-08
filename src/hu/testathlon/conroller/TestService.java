package hu.testathlon.conroller;

import hu.testathlon.model.domain.TestResult;
import hu.testathlon.model.domain.TestValidator;

import java.util.List;

public class TestService {

    private final TestValidator testValidator;
    private final List<TestResult> testResults;


    public TestService(TestValidator testValidator, List<TestResult> testResults) {
        this.testValidator = testValidator;
        this.testResults = testResults;
    }

    public int getCompetitorNumber() {
        return testResults.size();
    }

    public String getAnswersById(String id) {
        return getTestResultById(id).getAnwsers();
    }

    public String getCorrectAnswer() {
        return testValidator.getAnswers();
    }

    private TestResult getTestResultById(String id) {
        return testResults.stream()
                .filter(testResult -> testResult.getId().equals(id))
                .findAny()
                .get();
    }
}
