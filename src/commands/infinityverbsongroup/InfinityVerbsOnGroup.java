package commands.infinityverbsongroup;

import commands.Command;

public class InfinityVerbsOnGroup implements Command {
    private static InfinityVerbsOnGroup instance;

    private InfinityVerbsOnGroup() {
    }

    public static synchronized InfinityVerbsOnGroup getInstance() {
        if (instance == null) {
            instance = new InfinityVerbsOnGroup();
        }
        return instance;
    }

    @Override
    public Command execute() {
        return this;

    }
}
