import logic.Util;
import ui.Menu;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {

        Menu mainMenu = new Menu();

        mainMenu.mainMenu();

        Util.clearScreen();

    }
}
