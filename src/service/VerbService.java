package service;

import Utils.MenuUtils;
import holder.VerbHolder;
import models.Verb;
import models.VerbGroup;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class VerbService {
    private static VerbService verbService;
    private static VerbHolder holder = VerbHolder.getVerbHolder();
    private static final Random RANDOM = new Random();

    private List<Verb> correctVerbs;
    private List<Verb> incorrectVerbs;
    private VerbGroup currentGroup;

    public static synchronized VerbService getVerbService() {
        if (verbService == null) {
            verbService = new VerbService();
        }
        return verbService;
    }

    private VerbService() {
        correctVerbs = new ArrayList<>();
        incorrectVerbs = new ArrayList<>();
    }


    public List<Verb> getCorrectVerbs() {
        return correctVerbs;
    }

    public List<Verb> getIncorrectVerbs() {
        return incorrectVerbs;
    }

    public Verb getNextRandomVerb() {
        return holder.getVerbs().size() != 0 ? holder.getVerbs().get(RANDOM.nextInt(holder.getVerbsCount())) : null;
    }

    public Verb getVerbByGroup() {
        if (currentGroup != null) {
            return returnVerbAndRemoveFromGroup();
        } else {
            currentGroup = holder.getVerbGroupById(holder.getRandomVerbGroupId());
            return currentGroup.getVerbList().get(RANDOM.nextInt(currentGroup.getVerbList().size()));
        }
    }

    private Verb returnVerbAndRemoveFromGroup() {
        Verb newVerb;
        if (currentGroup.getVerbList().size() != 0){
            newVerb = currentGroup.getVerbList().get(RANDOM.nextInt(currentGroup.getVerbList().size()));
            removeVerbFromCurrentVerbList(newVerb);

        } else {
            currentGroup = null;
            newVerb = getVerbByGroup();
        }
        return newVerb;
    }

    private void removeVerbFromCurrentVerbList(Verb newVerb) {
        Iterator iterator = currentGroup.getVerbList().iterator();

        while (iterator.hasNext()){
            Verb thisVerb = (Verb) iterator.next();

            if (thisVerb.getGroup() == newVerb.getGroup()){
                iterator.remove();
            }
        }
    }

    public void showResult(Verb inputVerb) {
        addVerbOnTimeHolder(inputVerb);

        String resultString = ("Глагол на русском: " + inputVerb.getTranslate() + "\n") +
                Verb.HEADER_ONE + " " + inputVerb.getVerb() +
                (inputVerb.getVerb().equalsIgnoreCase(inputVerb.getCorrectVerb())
                        ? " - Верно\n"
                        : " Не верно, верная форма - " + inputVerb.getCorrectVerb() + "\n") +
                Verb.HEADER_TWO + " " + inputVerb.getPastSimple() +
                (inputVerb.getPastSimple().equalsIgnoreCase(inputVerb.getCorrectPastSimple())
                        ? " - Верно\n"
                        : " Не верно, верная форма - " + inputVerb.getCorrectPastSimple() + "\n") +
                Verb.HEADER_THREE + " " + inputVerb.getPastParticiple() +
                (inputVerb.getPastParticiple().equalsIgnoreCase(inputVerb.getCorrectPastParticiple())
                        ? " - Верно\n"
                        : " Не верно, верная форма - " + inputVerb.getCorrectPastParticiple() + "\n");

        System.out.printf(resultString + "\n");
    }

    private void addVerbOnTimeHolder(Verb inputVerb) {
        boolean isCorrectVerb = inputVerb.getVerb().equalsIgnoreCase(inputVerb.getCorrectVerb())
                && inputVerb.getPastSimple().equalsIgnoreCase(inputVerb.getCorrectPastSimple())
                && inputVerb.getPastParticiple().equalsIgnoreCase(inputVerb.getCorrectPastParticiple());

        List<Verb> currentList = isCorrectVerb ? correctVerbs : incorrectVerbs;

        if (!containOnArray(currentList, inputVerb)) {
            currentList.add(inputVerb);
        }
    }

    private boolean containOnArray(List<Verb> currentList, Verb inputVerb) {
        for (Verb verb : currentList) {
            if (verb.getVerb().equalsIgnoreCase(inputVerb.getVerb())) {
                return true;
            }
        }
        return false;
    }

    public void showErrors() {
        MenuUtils.printSeparator();
        System.out.println("Верные глаголы:");
        printArray(correctVerbs);
        System.out.println("Не верные глаголы:");
        printArray(incorrectVerbs);
        MenuUtils.printSeparator();
        System.out.println();
    }

    private void printArray(List<Verb> arrayList) {
        if (arrayList.size() != 0) {
            for (Verb verb : arrayList) {
                System.out.println(verb.getTranslate() +
                        ", " + (verb.getVerb().equalsIgnoreCase(verb.getCorrectVerb())
                        ? verb.getVerb()
                        : verb.getVerb() + "( Верная форма - " + verb.getCorrectVerb() + " )") +
                        ", " + (verb.getPastSimple().equalsIgnoreCase(verb.getCorrectPastSimple())
                        ? verb.getPastSimple()
                        : verb.getPastSimple() + "( Верная форма - " + verb.getCorrectPastSimple() + " )") +
                        ", " + (verb.getPastParticiple().equalsIgnoreCase(verb.getCorrectPastParticiple())
                        ? verb.getPastParticiple()
                        : verb.getPastParticiple() + "( Верная форма - " + verb.getCorrectPastParticiple() + " )"));
            }
        } else {
            System.out.println("Список пуст.");
        }
    }

    public void resetVerbs() {
        correctVerbs = new ArrayList<>();
        incorrectVerbs = new ArrayList<>();
    }

    public void showResultAndRemoveCurrentVerbFromHolder(Verb inputVerb) {
        removeVerbFromHolder(inputVerb);
        showResult(inputVerb);
    }

    private void removeVerbFromHolder(Verb inputVerb) {
        Iterator verbListIterator = VerbHolder.getVerbHolder().getVerbs().iterator();

        while (verbListIterator.hasNext()) {
            Verb verb = (Verb) verbListIterator.next();
            if (verb.getVerb().equalsIgnoreCase(inputVerb.getCorrectVerb())) {
                verbListIterator.remove();
            }
        }
    }
}
