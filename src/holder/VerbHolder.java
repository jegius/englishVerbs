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
        verbs.add(new Verb("let", "let", "let", "позволять", 1));
        verbs.add(new Verb("hit", "hit", "hit", "попасть в цель", 1));
        verbs.add(new Verb("hurt", "hurt", "hurt", "ушибить", 1));
        verbs.add(new Verb("put", "put", "put", "положить", 1));
        verbs.add(new Verb("quit", "quit", "quit", "выходить", 1));
        verbs.add(new Verb("read", "read", "read", "читать", 1));
        verbs.add(new Verb("set", "set", "set", "ставить", 1));
        verbs.add(new Verb("shut", "shut", "shut", "закрывать", 1));
        verbs.add(new Verb("spread", "spread", "spread", "расстилать", 1));
        verbs.add(new Verb("wet", "wet", "wet", "мочить", 1));

        verbs.add(new Verb("become", "became", "become", "становиться", 3));
        verbs.add(new Verb("begin", "began", "begun", "начинать", 3));
        verbs.add(new Verb("come", "came", "come", "приходить", 3));
        verbs.add(new Verb("grow", "grew", "grown", "расти", 3));
        verbs.add(new Verb("lie", "lay", "lain", "лежать", 3));
        verbs.add(new Verb("drink", "drank", "drunk", "пить", 3));
        verbs.add(new Verb("sing", "sang", "sung", "петь", 3));

        verbs.add(new Verb("hang", "hung", "hung", "вешать", 4));
        verbs.add(new Verb("keep", "kept", "kept", "содержать", 4));
        verbs.add(new Verb("hold", "held", "held", "держать", 4));
        verbs.add(new Verb("hav", "had", "had", "иметь", 4));
        verbs.add(new Verb("hear", "heard", "heard", "слышать", 4));
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
        verbs.add(new Verb("kneel", "knelt", "knelt", "стоять на коленях", 4));
        verbs.add(new Verb("lay", "laid", "laid", "класть", 4));
        verbs.add(new Verb("lead", "led", "led", "вести", 4));
        verbs.add(new Verb("lean", "leant", "leant", "наклоняться", 4));
        verbs.add(new Verb("learn", "learnt", "learnt", "учить", 4));
        verbs.add(new Verb("leave", "left", "left", "оставлять\\поднимать", 4));
        verbs.add(new Verb("lose", "lost", "lost", "терять", 4));
        verbs.add(new Verb("make", "made", "made", "производить", 4));
        verbs.add(new Verb("lend", "lent", "lent", "занимать", 4));
        verbs.add(new Verb("mean", "meant", "meant", "значить", 4));
        verbs.add(new Verb("meet", "met", "met", "встречать", 4));
        verbs.add(new Verb("pay", "paid", "paid", "платить", 4));
        verbs.add(new Verb("run", "ran", "run", "бежать", 4));
        verbs.add(new Verb("say", "said", "said", "говорить", 4));
        verbs.add(new Verb("seek", "sought", "sought", "искать", 4));
        verbs.add(new Verb("sit", "sat", "sat", "сидеть", 4));
        verbs.add(new Verb("sell", "sold", "sold", "продавать", 4));
        verbs.add(new Verb("light", "lit", "lit", "освещать", 4));
        verbs.add(new Verb("send", "sent", "sent", "посылать", 4));
        verbs.add(new Verb("sleep", "slept", "slept", "спать", 4));
        verbs.add(new Verb("slide", "slid", "slid", "скользить", 4));
        verbs.add(new Verb("spell", "spelt", "spelt", "произносить по буквам", 4));
        verbs.add(new Verb("spend", "spent", "spent", "тратить", 4));
        verbs.add(new Verb("spill", "spilt", "spilt", "проливать", 4));
        verbs.add(new Verb("spoil", "spoilt", "spoilt", "портиь", 4));
        verbs.add(new Verb("stand", "stood", "stood", "стоять", 4));
        verbs.add(new Verb("stick", "stuck", "stuck", "колоть", 4));
        verbs.add(new Verb("sting", "stung", "stung", "жалить", 4));
        verbs.add(new Verb("sweep", "swept", "swept", "выметать", 4));
        verbs.add(new Verb("swing", "swung", "swung", "качать", 4));
        verbs.add(new Verb("teach", "taught", "taught", "учить", 4));
        verbs.add(new Verb("tell", "told", "told", "рассказывать", 4));
        verbs.add(new Verb("think", "thought", "thought", "думать", 4));
        verbs.add(new Verb("understand", "understood", "understood", "понимать", 4));
        verbs.add(new Verb("weep", "wept", "wept", "плакать", 4));
        verbs.add(new Verb("win", "won", "won", "выигрывать", 4));
        verbs.add(new Verb("wind", "wound", "wound", "извиваться", 4));


        verbs.add(new Verb("swim", "swam", "swum", "плавать", 7));
        verbs.add(new Verb("spring", "sprang", "sprung", "портиь", 7));
        verbs.add(new Verb("sink", "sank", "sunk", "тонуть", 7));
        verbs.add(new Verb("ring", "rang", "rung", "звенеть", 7));
        verbs.add(new Verb("shrink", "shrank", "shrunk", "уменьшать", 7));

        verbs.add(new Verb("take", "took", "taken", "брать", 5));
        verbs.add(new Verb("prove", "proved", "proven", "доказывать", 5));
        verbs.add(new Verb("ride", "rode", "ridden", "ездить верхом", 5));
        verbs.add(new Verb("mistake", "mistook", "mistaken", "ошибаться", 5));
        verbs.add(new Verb("choose", "chose", "chosen", "выбирать", 5));
        verbs.add(new Verb("beat", "beat", "beaten", "бить", 5));
        verbs.add(new Verb("rise", "rose", "risen", "подниматься", 5));
        verbs.add(new Verb("hide", "hid", "hidden", "прятать", 5));
        verbs.add(new Verb("break", "broke", "broken", "ломать", 5));
        verbs.add(new Verb("drive", "drove", "driven", "водить", 5));
        verbs.add(new Verb("fall", "fell", "fallen", "падать", 5));
        verbs.add(new Verb("eat", "ate", "eaten", "есть", 5));
        verbs.add(new Verb("forget", "forgot", "forgotten", "забывать", 5));
        verbs.add(new Verb("forgive", "forgave", "forgiven", "прощать", 5));
        verbs.add(new Verb("freeze", "froze", "frozen", "замерзать", 5));
        verbs.add(new Verb("give", "gave", "given", "давать", 5));
        verbs.add(new Verb("shake", "shook", "shaken", "встряхивать", 5));
        verbs.add(new Verb("steal", "stole", "stolen", "красть", 5));
        verbs.add(new Verb("write", "wrote", "written", "писать", 5));
        verbs.add(new Verb("see", "saw", "seen", "видеть", 5));
        verbs.add(new Verb("speak", "spoke", "spoken", "говорить", 5));
        verbs.add(new Verb("wake", "woke", "woken", "просыпаться", 5));

        verbs.add(new Verb("know", "knew", "known", "знать", 8));
        verbs.add(new Verb("blow", "blew", "blown", "дуть", 8));
        verbs.add(new Verb("draw", "drew", "drawn", "рисовать", 8));
        verbs.add(new Verb("fly", "flew", "flown", "летать", 8));
        verbs.add(new Verb("throw", "threw", "thrown", "бросать", 8));
        verbs.add(new Verb("wear", "wore", "worn", "носить", 8));

        verbs.add(new Verb("show", "showed", "shaken", "показывать", 2));
        verbs.add(new Verb("sew", "sewed", "sewn", "шить", 2));
        verbs.add(new Verb("sow", "sowed", "sown", "сеять", 2));
        verbs.add(new Verb("swell", "swelled", "swollen", "сеять", 2));

        verbs.add(new Verb("do", "did", "done", "делать", 6));
        verbs.add(new Verb("be", "was/were", "been", "быть", 6));
        verbs.add(new Verb("tear", "tore", "torn", "рвать", 6));
        verbs.add(new Verb("go", "went", "gone", "идти", 6));

        return verbs;
    }

    public long getRandomVerbGroupId() {
        return verbsInGroup.get(new Random().nextInt(verbsInGroup.size())).getVerbGroup();
    }
}
