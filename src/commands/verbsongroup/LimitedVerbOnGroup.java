package commands.verbsongroup;

import Utils.MenuUtils;
import commands.Command;
import commands.MainMenu;
import models.Verb;
import service.VerbService;

import java.util.Scanner;

public class LimitedVerbOnGroup implements Command {
    private static LimitedVerbOnGroup instance;
    private Verb inputVerb;

    private LimitedVerbOnGroup() {
    }

    public static synchronized LimitedVerbOnGroup getInstance() {
        if (instance == null) {
            instance = new LimitedVerbOnGroup();
        }
        return instance;
    }

    @Override
    public Command execute() {

        VerbService verbService = VerbService.getVerbService();
        Scanner scanner = new Scanner(System.in);


        if (inputVerb == null) {
            Verb nextVerb = verbService.getVerbByGroup();
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
            verbService.showResult(inputVerb);
            inputVerb = null;
        }
        return this;
    }
}
