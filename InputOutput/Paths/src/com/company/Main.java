package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
        PrintFile(path);
        System.out.println();
        Path filePath = FileSystems.getDefault().getPath("files", "SubdirectoryFile.txt");
        /*
        We need to specify the directory name to get the path of SubdirectoryFile.txt since it is located in
        project working directory. Alternatively, we can use the Paths instance to get the path of file in project
        working directory. We need to add one more parameter as period ".".
         */
        filePath = Paths.get(".", "files", "SubdirectoryFile.txt");
        PrintFile(filePath);
        System.out.println();
        filePath = Paths.get("/Users/deepanshusarawagi/Desktop/Learning/Java/OutThere.txt");
        PrintFile(filePath);

        filePath = Paths.get(".");
        System.out.println(filePath.toAbsolutePath());

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
