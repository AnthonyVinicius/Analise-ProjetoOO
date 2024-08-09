package br.com.ifpe.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static final String LOG_FILE = "log.txt";

    public static void log(String message){
        File file = new File(LOG_FILE);
        try(FileWriter writer = new FileWriter(LOG_FILE, true)){
            writer.write(message);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao Loggar");
        }
    }

    public static void info(String message){
        log("Info: " + message);
    }

    public static void error(String message){
        log("Error: " + message);
    }

}
