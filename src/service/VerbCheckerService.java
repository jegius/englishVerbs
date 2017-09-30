package service;

import holder.VerbHolder;
import models.Verb;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VerbCheckerService {
    private static VerbCheckerService verbCheckerService;
    private static VerbHolder holder = VerbHolder.getVerbHolder();
    private static final Random RANDOM = new Random();

    private List<Verb> correctVerbs;
    private List<Verb> incorrectVerbs;

    public static synchronized VerbCheckerService getVerbHolder() {
        if (verbCheckerService == null) {
            verbCheckerService = new VerbCheckerService();
        }
        return verbCheckerService;
    }

    private VerbCheckerService(){
            correctVerbs = new ArrayList<>();
            incorrectVerbs = new ArrayList<>();
    }

    public String nextVerbRusName() {
        return holder.getVerbs().get(RANDOM.nextInt(holder.getVerbsCount())).getTranslate();
    }


    public String checkVerb(Verb newVerb) {
        StringBuilder stringBuilder = new StringBuilder();
        Verb inputVerb = getVerb(newVerb.getTranslate());
        assert inputVerb != null;

        newVerb.setVerbIsCorrect(inputVerb.getVerb().equals(newVerb.getVerb()));
        newVerb.setPastSimpleIsCorrect(inputVerb.getPastSimple().equals(newVerb.getPastSimple()));
        newVerb.setPastParticipleIsCorrect(inputVerb.getPastParticiple().equals(newVerb.getPastParticiple()));

        addVerbToArray(newVerb);
        return stringBuilder.append("Глагол: ").append(newVerb.isVerbIsCorrect() ? "верен " : "не верен ")
                .append("PastSimple: ").append(newVerb.isPastSimpleIsCorrect() ? "верен " : "не верен ")
                .append("PastParticiple: ").append(newVerb.isPastParticipleIsCorrect() ? "верен " : "не верен ")
                .toString();
    }

    private void addVerbToArray(Verb newVerb) {
        boolean verbIsCorrect = newVerb.isVerbIsCorrect()
                && newVerb.isPastParticipleIsCorrect()
                && newVerb.isPastSimpleIsCorrect();
        if (verbIsCorrect) {
            checkVerbOnExistOnArray(newVerb, true);
        } else {
            checkVerbOnExistOnArray(newVerb, false);
        }

    }

    private void checkVerbOnExistOnArray(Verb newVerb, boolean verbIsCorrect) {
        List<Verb> currentList = verbIsCorrect ? correctVerbs : incorrectVerbs;

        if(currentList.size() == 0){
            currentList.add(newVerb);
        } else {
            for (Verb verb : currentList) {
                if (verb.getVerb().equalsIgnoreCase(newVerb.getVerb())) {
                    return;
                }
            }

            currentList.add(newVerb);
        }
    }

    private Verb getVerb(String translate) {
        for (Verb verb : holder.getVerbs()) {
            if (translate.equals(verb.getTranslate())) {
                return verb;
            }
        }
        return null;
    }

    public List<Verb> getCorrectVerbs() {
        return correctVerbs;
    }

    public List<Verb> getIncorrectVerbs() {
        return incorrectVerbs;
    }
}
