package models;

public class Verb {
    public static final String HEADER_ONE = "Глагол: ";
    public static final String HEADER_TWO = "Past Simple: ";
    public static final String HEADER_THREE = "Past Participle: ";


    private String verb;
    private String pastSimple;
    private String pastParticiple;
    private String translate;
    private long group;

    private String correctVerb;
    private String correctPastSimple;
    private String correctPastParticiple;

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

    public String getCorrectVerb() {
        return correctVerb;
    }

    public void setCorrectVerb(String correctVerb) {
        this.correctVerb = correctVerb;
    }

    public String getCorrectPastSimple() {
        return correctPastSimple;
    }

    public void setCorrectPastSimple(String correctPastSimple) {
        this.correctPastSimple = correctPastSimple;
    }

    public String getCorrectPastParticiple() {
        return correctPastParticiple;
    }

    public void setCorrectPastParticiple(String correctPastParticiple) {
        this.correctPastParticiple = correctPastParticiple;
    }
}
