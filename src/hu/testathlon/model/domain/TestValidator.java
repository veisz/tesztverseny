package hu.testathlon.model.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestValidator {

    private static  final int[] POINTS = {3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 6};

    private final String answers;

    public TestValidator(String answers) {
        this.answers = answers;
    }

    public String getAnswers() {
        return answers;
    }

    public String checkResults(String competitorAnwsers) {
        return IntStream.range(0, answers.length())
                .mapToObj(i -> checkAnswer(competitorAnwsers, i))
                .collect(Collectors.joining());
    }

    public int calculatorScore(String competitorAnwsers) {
        return IntStream.range(0, answers.length())
                .map(i -> getScore(competitorAnwsers, i))
                .sum();
    }

    public boolean isCorrect(String competitorAnwsers, int i) {
        return answers.charAt(i) == competitorAnwsers.charAt(i);
    }

    private String checkAnswer(String competitorAnwsers, int i) {
        return isCorrect(competitorAnwsers, i) ? "+" : " ";
    }

    private int getScore(String competitorAnwsers, int i) {
        return  isCorrect(competitorAnwsers, i) ? POINTS[i] : 0;
    }
}
