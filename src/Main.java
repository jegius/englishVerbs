import aplication.ConsoleMenu;
import commands.MainMenu;

public class Main {

    public static void main(String[] args) {
        ConsoleMenu menu = new ConsoleMenu(MainMenu.getInstance());
        menu.run();
    }
}
