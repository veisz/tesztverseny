package hu.testathlon.model.domain;

public class TestResult {
    private final String id;

    public TestResult(String id, String anwsers) {
        this.id = id;
        this.anwsers = anwsers;
    }

    private final String anwsers;

    public String getId() {
        return id;
    }

    public String getAnwsers() {
        return anwsers;
    }
}
