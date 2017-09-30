package commands;

import Utils.MenuUtils;
import commands.infinityverbsongroup.InfinityVerbsOnGroup;
import commands.randominfinityverbs.RandomInfinityVerbsCommand;
import commands.randomlimitedverb.RandomLimitedVerbsCommand;
import commands.verbsongroup.LimitedVerbOnGroup;

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
        MenuUtils.printOption("2", "Глаголы по группам с ограничением");
        MenuUtils.printOption("3", "Случайные глаголы");
        MenuUtils.printOption("4", "Случайные глаголы с ограничением");
        MenuUtils.printOption("0", "Выход");
        MenuUtils.printSeparator();
        MenuUtils.printPrompt();

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 0:
                return ExitCommand.getInstance();
            case 1:
                return InfinityVerbsOnGroup.getInstance();
            case 2:
                return LimitedVerbOnGroup.getInstance();
            case 3:
                return RandomInfinityVerbsCommand.getInstance();
            case 4:
                return RandomLimitedVerbsCommand.getInstance();
            default:
                System.out.println("Неверная команда!");
                return this;
        }
    }
}
