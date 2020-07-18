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

        directory = FileSystems.getDefault().getPath("FileTree" + separator + "Dir2");
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory, filter)){
            for (Path path : directoryStream) {
                System.out.println(path.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Code to create the temporary file

        try {
            Path tempFile = Files.createTempFile("myapp", ".appext");
            System.out.println(tempFile.toAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Code to get the FileStores or volumes
        Iterable<FileStore> fileStores = FileSystems.getDefault().getFileStores();
        for (FileStore fileStore : fileStores) {
            System.out.println(fileStore.name());
        }

        System.out.println("******************");
        Iterable<Path> rootDirectories = FileSystems.getDefault().getRootDirectories();
        for (Path path : rootDirectories) {
            System.out.println(path);
        }

        System.out.println("Walking tree for dir2");
        Path dir2 = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");
        try {
            Files.walkFileTree(dir2, new PrintNames());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Copy Dir2 to Dir4/Dir2Copy");
        Path copyDir = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir4"
                + File.separator + "Dir2Copy");
        try {
            Files.walkFileTree(dir2, new CopyFiles(dir2, copyDir));
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
