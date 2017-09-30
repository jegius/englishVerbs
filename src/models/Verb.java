package models;

public class Verb {
    private String verb;
    private String pastSimple;
    private String pastParticiple;
    private String translate;
    private long group;

    private boolean verbIsCorrect;
    private boolean pastSimpleIsCorrect;
    private boolean pastParticipleIsCorrect;
    private boolean translateIsCorrect;

    public Verb() {
    }

    public Verb(String verb, String pastSimple, String pastParticiple, String translate, long group) {
        this.verb = verb;
        this.pastSimple = pastSimple;
        this.pastParticiple = pastParticiple;
        this.translate = translate;
        this.group = group;
    }

    public long getGroup() {
        return group;
    }

    public void setGroup(long group) {
        this.group = group;
    }

    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public String getPastSimple() {
        return pastSimple;
    }

    public void setPastSimple(String pastSimple) {
        this.pastSimple = pastSimple;
    }

    public String getPastParticiple() {
        return pastParticiple;
    }

    public void setPastParticiple(String pastParticiple) {
        this.pastParticiple = pastParticiple;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    public boolean isVerbIsCorrect() {
        return verbIsCorrect;
    }

    public void setVerbIsCorrect(boolean verbIsCorrect) {
        this.verbIsCorrect = verbIsCorrect;
    }

    public boolean isPastSimpleIsCorrect() {
        return pastSimpleIsCorrect;
    }

    public void setPastSimpleIsCorrect(boolean pastSimpleIsCorrect) {
        this.pastSimpleIsCorrect = pastSimpleIsCorrect;
    }

    public boolean isPastParticipleIsCorrect() {
        return pastParticipleIsCorrect;
    }

    public void setPastParticipleIsCorrect(boolean pastParticipleIsCorrect) {
        this.pastParticipleIsCorrect = pastParticipleIsCorrect;
    }

    public boolean isTranslateIsCorrect() {
        return translateIsCorrect;
    }

    public void setTranslateIsCorrect(boolean translateIsCorrect) {
        this.translateIsCorrect = translateIsCorrect;
    }
}
