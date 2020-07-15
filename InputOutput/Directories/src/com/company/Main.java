package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {
        Path directory = FileSystems.getDefault().getPath("FileTree/Dir2");

        try(DirectoryStream<Path> contents = Files.newDirectoryStream(directory, "*.txt")) {
            // add the second parameter in the method newDirectoryStream(glob) to file any files with a specific
            // extension.
            for (Path file : contents) {
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException e) {
            e.printStackTrace();
        }

        System.out.println();

        // We can also create our own filter using the class DirectoryStream.Filter<T>

        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path entry) throws IOException {
                return Files.isRegularFile(entry);
            }
        };

        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter)){
            for (Path path : contents) {
                System.out.println(path.getFileName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Get the default filesystem separator of your OS

        String separator = File.separator;
        System.out.println(separator);
        separator = FileSystems.getDefault().getSeparator();
        System.out.println(separator);
    }
}
