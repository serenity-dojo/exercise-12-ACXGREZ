package com.serenitydojo.exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileLoader {
    public String readHelloWorld() throws IOException {
        try {
            return Files.readString(Paths.get("path/to/hello/world/file"));
        } catch (IOException e) {
            // Handle the IOException gracefully
            // For example, log an error message and return a default value
            System.err.println("Error reading hello world file: " + e.getMessage());
            return "Hello World";
        }
    }


//    public boolean fileContainsText(String filename, String expectedText) {
//        String path = "src/main/resources/" + filename;
//        try {
//            return (Files.readString(Paths.get(path)).contains(expectedText));
//        } catch (IOException e) {
//            return false;
//        }
//    }

    public boolean fileContainsText(String filename, String expectedText) {
        String path = "src/main/resources/" + filename;
        try {
            String fileContents = Files.readString(Paths.get(path));
            return fileContents.contains(expectedText);
        } catch (IOException e) {
            // Handle the IOException gracefully
            // For example, log an error message and return false
            System.err.println("Error reading file: " + e.getMessage());
            return false;
        }
    }



    public boolean fileHasText(String filename, String expectedText) {
        String path = "src/main/resources/" + filename;
        try {
            return Files.readString(Paths.get(path)).contains(expectedText);
        } catch (IOException e) {
            throw new MissingWelcomeFileException("Missing welcome file: " + filename, e);
        }
    }

}
