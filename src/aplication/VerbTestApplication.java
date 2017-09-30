package aplication;


import models.Verb;
import service.VerbCheckerService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

public class VerbTestApplication {
    private VerbCheckerService verbCheckerService = VerbCheckerService.getVerbHolder();

    public void run() {


        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            do {
                Verb newVerb = new Verb();
                newVerb.setTranslate(verbCheckerService.nextVerbRusName());

                System.out.println("Введите перевод глагола: " + newVerb.getTranslate());
                newVerb.setVerb(bufferedReader.readLine().trim());
                System.out.println("Введите PastSimple: ");
                newVerb.setPastSimple(bufferedReader.readLine().trim());
                System.out.println("Введите Past Participle: ");
                newVerb.setPastParticiple(bufferedReader.readLine().trim());
                System.out.println(verbCheckerService.checkVerb(newVerb));

                if (Objects.equals(bufferedReader.readLine(), "result")) {
                    System.out.println("Результат:");
                    System.out.println("=================================================");
                    System.out.println("Верные глаголы:");
                    printVerbs(verbCheckerService.getCorrectVerbs());
                    System.out.println("=================================================");
                    System.out.println("Что стоит повторить:");
                    printVerbs(verbCheckerService.getIncorrectVerbs());
                }
            } while (!Objects.equals(bufferedReader.readLine(), "exit"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void printVerbs(List<Verb> verbs) {
        StringBuilder stringBuilder = new StringBuilder();
        if (verbs.size() == 0) {
            System.out.println("Нет глаголов");
        } else {
            for (Verb verb : verbs) {
                stringBuilder.append(verb.getVerb())
                        .append(" - ")
                        .append(verb.isVerbIsCorrect() ? "верно" : "не верно")
                        .append(verb.getPastSimple())
                        .append(" - ")
                        .append(verb.isPastSimpleIsCorrect()  ? "верно" : "не верно")
                        .append(" - ")
                        .append(verb.getPastParticiple())
                        .append(" - ")
                        .append(verb.isPastParticipleIsCorrect());

            }
            System.out.println(stringBuilder.toString());
        }
    }
}
