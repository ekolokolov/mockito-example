package xyz.kolokolov.console.core;

import java.io.BufferedReader;
import java.io.IOException;

public class Server {

    private final BufferedReader reader;
    private final AppProcessor application;

    public Server(BufferedReader reader, AppProcessor application) {
        this.reader = reader;
        this.application = application;
    }

    public void run(){
        while (true) {
            try {
                String line = reader.readLine();
                String response = application.process(line);
                System.out.println(response);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
