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


        verbs.add(new Verb("become", "became", "become", "становиться", 2));
        verbs.add(new Verb("come", "came", "come", "приходить", 2));

        verbs.add(new Verb("buy", "bought", "bought", "покупать", 3));
        verbs.add(new Verb("teach", "taught", "taught", "учить кого либо", 3));
        verbs.add(new Verb("bring", "brought", "brought", "приносить", 3));
        verbs.add(new Verb("think", "thought", "thought", "думать", 3));
        verbs.add(new Verb("fight", "fought", "fought", "бороться", 3));
        verbs.add(new Verb("seek", "sought", "sought", "искать", 3));

        verbs.add(new Verb("spoil", "spoilt", "spoilt", "портиь", 4));
        verbs.add(new Verb("dream", "dreamt", "dreamt", "мечтать", 4));
        verbs.add(new Verb("learn", "learnt", "learnt", "учить самому что-либо", 4));
        verbs.add(new Verb("lean", "leant", "leant", "наклоняться", 4));
        verbs.add(new Verb("mean", "meant", "meant", "значить", 4));
        verbs.add(new Verb("burn", "burnt", "burnt", "гореть", 4));

        verbs.add(new Verb("catch", "caught", "caught", "ловить", 5));
        verbs.add(new Verb("build", "built", "built", "строить", 5));
        verbs.add(new Verb("feel", "felt", "felt", "чувствовать", 5));
        verbs.add(new Verb("creep", "crept", "crept", "ползать", 5));
        verbs.add(new Verb("keep", "kept", "kept", "содержать", 5));
        verbs.add(new Verb("kneel", "knelt", "knelt", "стоять на коленях", 5));
        verbs.add(new Verb("leave", "left", "left", "оставлять\\поднимать", 5));
        verbs.add(new Verb("lend", "lent", "lent", "занимать", 5));
        verbs.add(new Verb("sleep", "slept", "slept", "спать", 5));
        verbs.add(new Verb("spell", "spelt", "spelt", "произносить по буквам", 5));
        verbs.add(new Verb("spend", "spent", "spent", "тратить", 5));
        verbs.add(new Verb("send", "sent", "sent", "посылать", 5));
        verbs.add(new Verb("sweep", "swept", "swept", "выметать", 5));
        verbs.add(new Verb("lose", "lost", "lost", "терять", 5));
        verbs.add(new Verb("sit", "sat", "sat", "сидеть", 5));
        verbs.add(new Verb("spill", "spilt", "spilt", "проливать", 5));
        verbs.add(new Verb("weep", "wept", "wept", "плакать", 5));

        verbs.add(new Verb("lead", "led", "led", "вести", 6));
        verbs.add(new Verb("meet", "met", "met", "встречать", 6));
        verbs.add(new Verb("light", "lit", "lit", "освещать", 6));



        verbs.add(new Verb("hang", "hung", "hung", "вешать", 7));
        verbs.add(new Verb("hold", "held", "held", "держать", 7));
        verbs.add(new Verb("have", "had", "had", "иметь", 7));
        verbs.add(new Verb("hear", "heard", "heard", "слышать", 7));
        verbs.add(new Verb("bleed", "bled", "bled", "кровоточить", 7));
        verbs.add(new Verb("find", "found", "found", "находить", 7));
        verbs.add(new Verb("lay", "laid", "laid", "класть", 7));
        verbs.add(new Verb("pay", "paid", "paid", "платить", 7));
        verbs.add(new Verb("make", "made", "made", "производить", 7));
        verbs.add(new Verb("say", "said", "said", "сказать", 7));
        verbs.add(new Verb("sell", "sold", "sold", "продавать", 7));
        verbs.add(new Verb("slide", "slid", "slid", "скользить", 7));
        verbs.add(new Verb("can", "could", "could", "мочь", 7));
        verbs.add(new Verb("stick", "stuck", "stuck", "колоть", 7));
        verbs.add(new Verb("sting", "stung", "stung", "жалить", 7));
        verbs.add(new Verb("swing", "swung", "swung", "качать", 7));
        verbs.add(new Verb("tell", "told", "told", "рассказывать", 7));
        verbs.add(new Verb("win", "won", "won", "выигрывать", 7));
        verbs.add(new Verb("wind", "wound", "wound", "извиваться", 7));

        verbs.add(new Verb("begin", "began", "begun", "начинать", 8));
        verbs.add(new Verb("drink", "drank", "drunk", "пить", 8));
        verbs.add(new Verb("sing", "sang", "sung", "петь", 8));
        verbs.add(new Verb("run", "ran", "run", "бежать", 8));
        verbs.add(new Verb("spring", "sprang", "sprung", "прыгать", 8));
        verbs.add(new Verb("swim", "swam", "swum", "плавать", 8));
        verbs.add(new Verb("sink", "sank", "sunk", "тонуть", 8));
        verbs.add(new Verb("ring", "rang", "rung", "звенеть", 8));
        verbs.add(new Verb("shrink", "shrank", "shrunk", "уменьшать", 8));


        verbs.add(new Verb("ride", "rode", "ridden", "ездить верхом", 9));
        verbs.add(new Verb("choose", "chose", "chosen", "выбирать", 9));
        verbs.add(new Verb("beat", "beat", "beaten", "бить", 9));
        verbs.add(new Verb("rise", "rose", "risen", "подниматься", 9));
        verbs.add(new Verb("hide", "hid", "hidden", "прятать", 9));
        verbs.add(new Verb("break", "broke", "broken", "ломать", 9));
        verbs.add(new Verb("drive", "drove", "driven", "водить", 9));
        verbs.add(new Verb("fall", "fell", "fallen", "падать", 9));
        verbs.add(new Verb("eat", "ate", "eaten", "есть", 9));
        verbs.add(new Verb("freeze", "froze", "frozen", "замерзать", 9));
        verbs.add(new Verb("shake", "shook", "shaken", "встряхивать", 9));
        verbs.add(new Verb("steal", "stole", "stolen", "красть", 9));
        verbs.add(new Verb("write", "wrote", "written", "писать", 9));
        verbs.add(new Verb("see", "saw", "seen", "видеть", 9));
        verbs.add(new Verb("speak", "spoke", "spoken", "говорить", 9));
        verbs.add(new Verb("wake", "woke", "woken", "просыпаться", 9));

        verbs.add(new Verb("grow", "grew", "grown", "расти", 10));
        verbs.add(new Verb("lie", "lay", "lain", "лежать", 10));
        verbs.add(new Verb("know", "knew", "known", "знать", 10));
        verbs.add(new Verb("blow", "blew", "blown", "дуть", 10));
        verbs.add(new Verb("draw", "drew", "drawn", "рисовать", 10));
        verbs.add(new Verb("fly", "flew", "flown", "летать", 10));
        verbs.add(new Verb("throw", "threw", "thrown", "бросать", 10));
        verbs.add(new Verb("wear", "wore", "worn", "носить", 10));

        verbs.add(new Verb("show", "showed", "shown", "показывать", 11));
        verbs.add(new Verb("sew", "sewed", "sewn", "шить", 11));
        verbs.add(new Verb("sow", "sowed", "sown", "сеять", 11));
        verbs.add(new Verb("swell", "swelled", "swollen", "разбухать", 11));
        verbs.add(new Verb("prove", "proved", "proven", "доказывать", 11));

        verbs.add(new Verb("do", "did", "done", "делать", 12));
        verbs.add(new Verb("be", "was/were", "been", "быть", 12));
        verbs.add(new Verb("tear", "tore", "torn", "рвать", 12));
        verbs.add(new Verb("go", "went", "gone", "идти", 12));

        verbs.add(new Verb("take", "took", "taken", "брать", 13));
        verbs.add(new Verb("mistake", "mistook", "mistaken", "ошибаться", 13));

        verbs.add(new Verb("understand", "understood", "understood", "понимать", 14));
        verbs.add(new Verb("stand", "stood", "stood", "стоять", 14));

        verbs.add(new Verb("get", "got", "got", "получать", 15));
        verbs.add(new Verb("forget", "forgot", "forgotten", "забывать", 15));

        verbs.add(new Verb("forgive", "forgave", "forgiven", "прощать", 16));
        verbs.add(new Verb("give", "gave", "given", "давать", 16));

        return verbs;
    }

    public long getRandomVerbGroupId() {
        return verbsInGroup.get(new Random().nextInt(verbsInGroup.size())).getVerbGroup();
    }
}
