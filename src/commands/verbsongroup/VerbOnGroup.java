package commands.verbsongroup;

import commands.Command;

public class VerbOnGroup implements Command {
    private static VerbOnGroup instance;

    private VerbOnGroup() {}

    public static synchronized VerbOnGroup getInstance() {
        if (instance == null) {
            instance = new VerbOnGroup();
        }
        return instance;
    }
    @Override
    public Command execute() {
        return this;
    }
}
