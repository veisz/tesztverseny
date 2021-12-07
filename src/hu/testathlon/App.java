package hu.testathlon;

import hu.testathlon.conroller.TestService;
import hu.testathlon.model.domain.TestValidator;
import hu.testathlon.model.service.DataApi;
import hu.testathlon.model.service.DataParser;
import hu.testathlon.model.service.FileReader;

public class App {

    private final TestService testService;
    DataApi dataApi = new DataApi("valaszok.txt", new FileReader(), new DataParser());

    private App() {
        testService = new TestService(new TestValidator(dataApi.getAnwsers()), dataApi.getTestResults());
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.println("2. feladat");
        System.out.println("A vetélkedőn " + testService.getCompetitorNumber() + " versenyző idult");
    }
}
