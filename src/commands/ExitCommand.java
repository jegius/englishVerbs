package commands;

public class ExitCommand implements Command {
    private ExitCommand() {
    }

    private static ExitCommand instance;

    @Override
    public Command execute() {
        return null;
    }

    static synchronized ExitCommand getInstance() {
        if (instance == null) {
            instance = new ExitCommand();
        }
        return instance;
    }
}
