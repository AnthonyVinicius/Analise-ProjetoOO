package br.com.ifpe.persistence;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static final String LOG_FILE = "log.txt";

    public static void log(String message) {
        File file = new File(LOG_FILE);
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(message);
        } catch (IOException e) {
            throw new RuntimeException("Registration error");
        }
    }

    public static void info(String message) {
        log("Info: " + message + "\n");
    }

    public static void error(String message) {
        log("Error: " + message + "\n");
    }

}
