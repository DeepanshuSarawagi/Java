package com.company;

import java.io.IOException;
import java.nio.file.*;

public class Paths2 {
    public static void main(String[] args) {
        try {
            Path sourceFile = FileSystems.getDefault().getPath("Examples", "file1.txt");
            Path copyFile = FileSystems.getDefault().getPath("Examples", "filecopy.txt");
            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);
            /*
            Use the StandardCopyOption.REPLACE_EXISTING parameter in the Files.copy() method to replace the file if
            already exists.
             */
            sourceFile = FileSystems.getDefault().getPath("Examples", "Dir1");
            copyFile = FileSystems.getDefault().getPath("Examples", "Dir4");

            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);

            /*
            Below is the code to move the file from source path to destination.
             */

            sourceFile = FileSystems.getDefault().getPath("Examples", "filecopy.txt");
            Path destination = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
            Files.move(sourceFile, destination, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
