package com.company;

import javax.lang.model.element.Name;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.FileAttribute;

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

            sourceFile = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
            destination = FileSystems.getDefault().getPath("Examples", "Dir1", "file1copy.txt");
            Files.move(sourceFile, destination, StandardCopyOption.REPLACE_EXISTING);

            /*
            Below is the code to delete the file.
             */

            Path fileToDelete = FileSystems.getDefault().getPath("Examples", "Dir1", "file1copy.txt");
            if (Files.exists(fileToDelete)) {
                Files.delete(fileToDelete);
            } else {
                System.out.println("File not found");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Paths3{
    public static void main(String[] args) throws IOException {
        /*
        Created new class to work more on Paths
         */

        Path fileToCreate = FileSystems.getDefault().getPath("Examples", "file2.txt");
        if (!Files.exists(fileToCreate)) {
            Files.createFile(fileToCreate);
        }

        Path dirToCreate = FileSystems.getDefault().getPath("Examples", "Dir4");
        if (!Files.exists(dirToCreate)) {
            Files.createDirectory(dirToCreate);
        }

        dirToCreate = FileSystems.getDefault().getPath("Examples/Dir2/Dir3/Dir4/Dir5/Dir6");
        if (!Files.exists(dirToCreate)) {
            Files.createDirectories(dirToCreate);
        }
    }
}
