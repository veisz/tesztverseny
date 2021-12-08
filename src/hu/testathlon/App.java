package hu.testathlon;

import hu.testathlon.conroller.TestService;
import hu.testathlon.model.domain.TestValidator;
import hu.testathlon.model.service.Console;
import hu.testathlon.model.service.DataApi;
import hu.testathlon.model.service.DataParser;
import hu.testathlon.model.service.FileReader;

import java.util.Scanner;

public class App {

    private final TestService testService;
    private final Console console;
    DataApi dataApi = new DataApi("valaszok.txt", new FileReader(), new DataParser());

    private App() {
        testService = new TestService(new TestValidator(dataApi.getAnwsers()), dataApi.getTestResults());
        console = new Console(new Scanner(System.in));
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.println("1. feladat: Az adatok beolvasása ");
        System.out.println("2. feladat");
        System.out.println("A vetélkedőn " + testService.getCompetitorNumber() + " versenyző idult");
        System.out.print("3. feladat: A versenyző azonosítója = ");
        String id = console.read();
        System.out.println(testService.getAnswersById(id) + "\t (A versenyző válasza");
        System.out.println("4. feladat");
        System.out.println(testService.getCorrectAnswer() + "\t (a helyes megoldás");
    }
}
