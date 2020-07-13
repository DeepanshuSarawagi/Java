package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
        PrintFile(path);
    }

    private static void PrintFile(Path path) {
        try (BufferedReader fileReader = Files.newBufferedReader(path)){
            String line;
            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
            e.printStackTrace();
        }
    }
}
