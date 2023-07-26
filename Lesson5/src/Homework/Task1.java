package Homework;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;


public class Task1 {

    public static void main(String[] args) throws IOException {
        String sourcePath = "./";
        String destinationPath = "./backup/";

        String[] fileNames = getFiles(sourcePath);
        startBackup(fileNames, destinationPath);
    }

    public static String[] getFiles(String sourceFilePath){
        File file = new File(sourceFilePath);
        String[] fileNames = file.list();
        return fileNames;
    }

    public static void startBackup(String[] files, String destinationFilePath) throws IOException {
        new File(destinationFilePath).mkdirs();
        try {
            for (String fileName : files){
                Files.copy(Path.of("./" + fileName), Path.of(destinationFilePath + fileName));
            }
        } catch (FileAlreadyExistsException e){
            System.out.println("File already exists " + e.getMessage());
        }
    }
}
