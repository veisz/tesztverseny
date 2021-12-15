package hu.testathlon.conroller;

import hu.testathlon.model.domain.FinalResult;
import hu.testathlon.model.domain.TestResult;
import hu.testathlon.model.domain.TestValidator;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<FinalResult> calulateScores() {
        return testResults.stream()
                .map(i -> new FinalResult(i.getId(), testValidator.calculatorScore()))
                .collect(Collectors.toCollection());
    }

    public String getAnswersById(String id) {
        return getTestResultById(id).getAnwsers();
    }

    public String getCorrectAnswer() {
        return testValidator.getAnswers();
    }

    public String getCheckedResultById(String id) {
        return testValidator.checkResults(getAnswersById(id));
    }

    public long countCorrectAnswersByTaskId(int taskId) {
        return testResults.stream()
                .filter(i -> testValidator.isCorrect(i.getAnwsers(), taskId))
                .count();
    }

    private TestResult getTestResultById(String id) {
        return testResults.stream()
                .filter(testResult -> testResult.getId().equals(id))
                .findAny()
                .get();
    }
}
