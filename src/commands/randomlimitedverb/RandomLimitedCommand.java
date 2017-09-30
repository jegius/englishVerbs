package commands.randomlimitedverb;

import Utils.MenuUtils;
import commands.Command;
import commands.ExitCommand;
import commands.MainMenu;
import commands.randominfinityverbs.RandomInfinityVerbsCommand;
import holder.VerbHolder;
import models.Verb;
import service.VerbService;

import java.util.Scanner;

public class RandomLimitedCommand implements Command{
    private static RandomLimitedCommand instance;
    private Verb inputVerb;

    private RandomLimitedCommand() {
    }

    public static synchronized RandomLimitedCommand getInstance() {
        if (instance == null) {
            instance = new RandomLimitedCommand();

        }
        return instance;
    }

    @Override
    public Command execute() {

        VerbService verbService = VerbService.getVerbService();
        Scanner scanner = new Scanner(System.in);

        if (inputVerb == null) {
            Verb nextVerb = verbService.getNextRandomVerb();
            if (nextVerb == null){
                System.out.println("В базе закончились глаголы.");
                MenuUtils.printSeparator();
                MenuUtils.printOption("1", "Для перезагрузки базы.");
                MenuUtils.printOption("2", "Для выхода в главное меню.");
                MenuUtils.printSeparator();

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        VerbHolder.getVerbHolder().refreshArray();
                        return this;
                    case 2:
                        return MainMenu.getInstance();
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
            MenuUtils.printOption("Осталось глаголов", "" + VerbHolder.getVerbHolder().getVerbsCount());
            MenuUtils.printOption("Верных глаголов", "" + VerbService.getVerbService().getCorrectVerbs().size());
            MenuUtils.printOption("Не верных глаголов", "" + VerbService.getVerbService().getIncorrectVerbs().size());
            MenuUtils.printSeparator();
            String chose = scanner.nextLine();
            if (chose.equals("0")) {
                verbService.resetVerbs();
                return MainMenu.getInstance();
            } else if (chose.equals("1")){
                verbService.showErrors();
            }
            verbService.showResultAndRemoveCurrentVerbFromHolder(inputVerb);
            inputVerb = null;
        }
        return this;
    }
}
