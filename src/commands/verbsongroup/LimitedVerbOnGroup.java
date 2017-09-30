package commands.verbsongroup;

import commands.Command;

public class LimitedVerbOnGroup implements Command {
    private static LimitedVerbOnGroup instance;

    private LimitedVerbOnGroup() {}

    public static synchronized LimitedVerbOnGroup getInstance() {
        if (instance == null) {
            instance = new LimitedVerbOnGroup();
        }
        return instance;
    }
    @Override
    public Command execute() {
        return this;
    }
}
