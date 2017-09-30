package commands.randominfinityverbs;

import Utils.MenuUtils;
import commands.Command;
import commands.MainMenu;
import models.Verb;
import service.VerbService;

import java.util.Scanner;

public class RandomInfinityVerbsCommand implements Command {
    private static RandomInfinityVerbsCommand instance;
    private Verb inputVerb;

    private RandomInfinityVerbsCommand() {
    }

    public static synchronized RandomInfinityVerbsCommand getInstance() {
        if (instance == null) {
            instance = new RandomInfinityVerbsCommand();

        }
        return instance;
    }

    @Override
    public Command execute() {

        VerbService verbService = VerbService.getVerbService();
        Scanner scanner = new Scanner(System.in);


        if (inputVerb == null) {
            Verb nextVerb = verbService.getNextRandomVerb();
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
            } else if (chose.equals("1")){
                verbService.showErrors();
            }
            verbService.showResult(inputVerb);
            inputVerb = null;
        }
        return this;
    }
}


