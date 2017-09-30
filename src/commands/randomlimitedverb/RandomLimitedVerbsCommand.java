package commands.randomlimitedverb;

import Utils.MenuUtils;
import commands.Command;
import commands.MainMenu;
import holder.VerbHolder;
import models.Verb;
import service.VerbService;

import java.util.Scanner;

public class RandomLimitedVerbsCommand implements Command {
    private static RandomLimitedVerbsCommand instance;
    private Verb inputVerb;

    private RandomLimitedVerbsCommand() {
    }

    public static synchronized RandomLimitedVerbsCommand getInstance() {
        if (instance == null) {
            instance = new RandomLimitedVerbsCommand();

        }
        return instance;
    }

    @Override
    public Command execute() {

        VerbService verbService = VerbService.getVerbService();
        Scanner scanner = new Scanner(System.in);

        if (inputVerb == null) {
            Verb nextVerb = verbService.getNextRandomVerb();
            if (nextVerb == null) {
                System.out.println("В базе закончились глаголы.");
                MenuUtils.printSeparator();
                MenuUtils.printOption("1", "Для перезагрузки базы.");
                MenuUtils.printOption("2", "Для выхода в главное меню.");
                MenuUtils.printOption("3", "Показать результаты");
                MenuUtils.printSeparator();

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        VerbHolder.getVerbHolder().refreshArray();
                        return this;
                    case 2:
                        return MainMenu.getInstance();
                    case 3:
                        verbService.showErrors();
                        return this;
                    default:
                        System.out.println("Неверная команда!");
                        return this;
                }
            }
            inputVerb = new Verb();
            System.out.println(nextVerb.getTranslate());
            inputVerb.setTranslate(nextVerb.getTranslate());
            inputVerb.setCorrectVerb(nextVerb.getVerb());
            inputVerb.setCorrectPastSimple(nextVerb.getPastSimple());
            inputVerb.setCorrectPastParticiple(nextVerb.getPastParticiple());
        }

        if (inputVerb.getVerb() == null) {
            System.out.println(Verb.HEADER_ONE);
            String nextString = scanner.nextLine();
            inputVerb.setVerb(nextString);
        } else if (inputVerb.getPastSimple() == null) {
            System.out.println(Verb.HEADER_TWO);
            String nextString = scanner.nextLine();
            inputVerb.setPastSimple(nextString);
        } else if (inputVerb.getPastParticiple() == null) {
            System.out.println(Verb.HEADER_THREE);
            String nextString = scanner.nextLine();
            inputVerb.setPastParticiple(nextString);
        } else {
            MenuUtils.printSeparator();
            MenuUtils.printOption("Выход из режима введите", "0");
            MenuUtils.printOption("Показ результата", "1");
            MenuUtils.printSeparator();
            String chose = scanner.nextLine();

            if (chose.equals("0")) {
                verbService.resetVerbs();
                return MainMenu.getInstance();
            } else if (chose.equals("1")) {
                verbService.showErrors();

            }
            verbService.showResultAndRemoveCurrentVerbFromHolder(inputVerb);
            inputVerb = null;
            MenuUtils.printSeparator();
            MenuUtils.printOption("Осталось глаголов", "" + VerbHolder.getVerbHolder().getVerbsCount());
            MenuUtils.printOption("Верных глаголов", "" + VerbService.getVerbService().getCorrectVerbs().size());
            MenuUtils.printOption("Не верных глаголов", "" + VerbService.getVerbService().getIncorrectVerbs().size());
            MenuUtils.printSeparator();
        }
        return this;
    }
}
