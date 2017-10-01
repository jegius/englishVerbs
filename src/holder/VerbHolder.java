package holder;

import models.Verb;
import models.VerbGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VerbHolder {
    private static VerbHolder verbHolder;
    private List<Verb> verbs;
    private List<VerbGroup> verbsInGroup;

    public static synchronized VerbHolder getVerbHolder() {
        if (verbHolder == null) {
            verbHolder = new VerbHolder();
        }
        return verbHolder;
    }

    private VerbHolder() {

        verbs = initVerbs();
        verbsInGroup = sortVerbsOnGroup();

    }

    private List<VerbGroup> sortVerbsOnGroup() {
        List<VerbGroup> verbGroups = new ArrayList<>();
        for (Verb verb : verbs) {
            if (verbGroups.size() == 0) {
                verbGroups.add(createNewVerbGroup(verb));
            } else {
                verbGroups = checkContainsAndAddIfNeeded(verb, verbGroups);
            }
        }
        return verbGroups;
    }

    public List<VerbGroup> getVerbsInGroup() {
        return verbsInGroup;
    }

    public VerbGroup getVerbGroupById(long id) {
        for (VerbGroup verbGroup : verbsInGroup) {
            if (verbGroup.getVerbGroup() == id) {
                if (verbGroup.getVerbList().size() != 0) {
                    return verbGroup;
                } else {
                  verbsInGroup = sortVerbsOnGroup();
                  return getVerbGroupById(id);
                }

            }
        }
        return null;
    }

    public int getVerbGroupListSize() {
        return verbsInGroup.size();
    }

    public void resetVerbGroups() {
        refreshArray();
        sortVerbsOnGroup();
    }

    private List<VerbGroup> checkContainsAndAddIfNeeded(Verb verb, List<VerbGroup> verbGroups) {
        if (isGroupOnExisting(verb, verbGroups)) {
            addVerbOnExistingVerbGroup(verb, verbGroups);
        } else {
            verbGroups.add(createNewVerbGroup(verb));
        }

        return verbGroups;
    }

    private void addVerbOnExistingVerbGroup(Verb verb, List<VerbGroup> verbGroups) {
        for (VerbGroup verbGroup : verbGroups) {
            if (verbGroup.getVerbGroup() == verb.getGroup()) {
                verbGroup.getVerbList().add(verb);
            }
        }
    }

    private boolean isGroupOnExisting(Verb verb, List<VerbGroup> verbGroups) {
        for (VerbGroup verbGroup : verbGroups) {
            if (verbGroup.getVerbGroup() == verb.getGroup()) {
                return true;
            }
        }
        return false;
    }

    private VerbGroup createNewVerbGroup(Verb verb) {
        VerbGroup verbGroup = new VerbGroup();
        verbGroup.setVerbGroup(verb.getGroup());
        verbGroup.addNewVerb(verb);

        return verbGroup;
    }

    public List<Verb> getVerbs() {
        return verbs;
    }

    public int getVerbsCount() {
        return verbs.size();
    }

    public void refreshArray() {
        verbs = initVerbs();
    }

    private List<Verb> initVerbs() {
        List<Verb> verbs = new ArrayList<>();
        verbs.add(new Verb("cut", "cut", "cut", "резать", 1));
        verbs.add(new Verb("burst", "burst", "burst", "разразиться", 1));
        verbs.add(new Verb("cost", "cost", "cost", "стоить", 1));
        verbs.add(new Verb("fit", "fit", "fit", "подходит по размеру", 1));

        verbs.add(new Verb("become", "became", "become", "становиться", 3));
        verbs.add(new Verb("begin", "began", "begun", "начинать", 3));
        verbs.add(new Verb("come", "came", "come", "приходить", 3));
        verbs.add(new Verb("grow", "grew", "grown", "расти", 3));

        verbs.add(new Verb("burn", "burnt", "burnt", "гореть", 4));
        verbs.add(new Verb("buy", "bought", "bought", "покупать", 4));
        verbs.add(new Verb("bring", "brought", "brought", "приносить", 4));
        verbs.add(new Verb("bleed", "bled", "bled", "кровоточить", 4));
        verbs.add(new Verb("build", "built", "built", "строить", 4));
        verbs.add(new Verb("catch", "caught", "caught", "ловить", 4));
        verbs.add(new Verb("creep", "crept", "crept", "ползать", 4));
        verbs.add(new Verb("dream", "dreamt", "dreamt", "мечтать", 4));
        verbs.add(new Verb("feel", "felt", "felt", "чувствовать", 4));
        verbs.add(new Verb("fight", "fought", "fought", "бороться", 4));
        verbs.add(new Verb("find", "found", "found", "находить", 4));
        verbs.add(new Verb("get", "got", "got", "получать", 4));

        verbs.add(new Verb("choose", "chose", "chosen", "выбирать", 5));
        verbs.add(new Verb("beat", "beat", "beaten", "бить", 5));
        verbs.add(new Verb("be", "was/were", "been", "быть", 5));
        verbs.add(new Verb("do", "did", "done", "делать", 5));
        verbs.add(new Verb("blow", "blew", "blown", "дуть", 5));
        verbs.add(new Verb("break", "broke", "broken", "ломать", 5));
        verbs.add(new Verb("draw", "drew", "drawn", "рисовать", 5));
        verbs.add(new Verb("drive", "drove", "driven", "водить", 5));
        verbs.add(new Verb("eat", "ate", "eaten", "есть", 5));
        verbs.add(new Verb("fall", "fell", "fallen", "падать", 5));
        verbs.add(new Verb("fly", "flew", "flown", "летать", 5));
        verbs.add(new Verb("forget", "forgot", "forgotten", "забывать", 5));
        verbs.add(new Verb("forgive", "forgave", "forgiven", "прощать", 5));
        verbs.add(new Verb("freeze", "froze", "frozen", "замерзать", 5));
        verbs.add(new Verb("give", "gave", "given", "давать", 5));

        verbs.add(new Verb("drink", "drank", "drunk", "пить", 6));
        verbs.add(new Verb("go", "went", "gone", "идти", 6));

        return verbs;
    }

    public long getRandomVerbGroupId() {
        return verbsInGroup.get(new Random().nextInt(verbsInGroup.size())).getVerbGroup();
    }
}
