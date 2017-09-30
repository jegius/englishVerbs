package holder;

import models.Verb;

import java.util.ArrayList;
import java.util.List;

public class VerbHolder {
    private static VerbHolder verbHolder;
    private List<Verb> verbs;

    public static synchronized VerbHolder getVerbHolder(){
        if (verbHolder == null){
            verbHolder = new VerbHolder();
        }
        return verbHolder;
    }

    private VerbHolder() {
        if (verbs == null){
            verbs = initVerbs();
        }
    }

    public List<Verb> getVerbs() {
        return verbs;
    }

    public int getVerbsCount(){
        return verbs.size();
    }

    public void refreshArray(){
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
        verbs.add(new Verb("get", "got", "got", "замерзать", 4));

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

}
