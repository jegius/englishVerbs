package commands;

import Utils.MenuUtils;
import commands.randominfinityverbs.RandomInfinityVerbsCommand;
import commands.randomlimitedverb.RandomLimitedCommand;
import commands.verbsongroup.VerbOnGroup;

import java.util.Scanner;

public class MainMenu implements Command {

    private static MainMenu instance;

    private MainMenu() {
    }

    public static synchronized MainMenu getInstance() {
        if (instance == null) {
            instance = new MainMenu();
        }
        return instance;
    }


    @Override
    public Command execute() {
        MenuUtils.printSeparator();
        MenuUtils.printOption("1", "Глаголы по группам");
        MenuUtils.printOption("2", "Случайные глаголы");
        MenuUtils.printOption("3", "Случайные глаголы с ограничением");
        MenuUtils.printOption("0", "Выход");
        MenuUtils.printSeparator();
        MenuUtils.printPrompt();

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 0:
                return ExitCommand.getInstance();
            case 1:
                return VerbOnGroup.getInstance();
            case 2:
                return RandomInfinityVerbsCommand.getInstance();
            case 3:
                return RandomLimitedCommand.getInstance();
            default:
                System.out.println("Неверная команда!");
                return this;
        }
    }
}
