package xyz.kolokolov.console.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Server {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final AppProcessor application = new AppProcessor();

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
