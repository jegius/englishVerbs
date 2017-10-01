package models;

import java.util.ArrayList;
import java.util.List;

public class VerbGroup {
    long verbGroup;
    List<Verb> verbList;
    String verbGroupDescription;

    public VerbGroup() {
        verbList = new ArrayList<>();
    }

    public long getVerbGroup() {
        return verbGroup;
    }

    public void addNewVerb(Verb verb){
        verbList.add(verb);
    }

    public void setVerbGroup(long verbGroup) {
        this.verbGroup = verbGroup;
    }

    public List<Verb> getVerbList() {
        return verbList;
    }

    public void setVerbList(List<Verb> verbList) {
        this.verbList = verbList;
    }

    public String getVerbGroupDescription() {
        return verbGroupDescription;
    }

    public void setVerbGroupDescription(String verbGroupDescription) {
        this.verbGroupDescription = verbGroupDescription;
    }
}
