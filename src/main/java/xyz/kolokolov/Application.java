package xyz.kolokolov;

import xyz.kolokolov.console.AppContext;
import xyz.kolokolov.console.core.Server;

public class Application {

    public static void main(String[] args) {
        Server server = AppContext.createAppServer();
        server.run();
    }
}
