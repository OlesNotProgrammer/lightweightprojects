package com.example.lightweightprojects;

import static java.util.stream.Collectors.joining;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {
    public static String readWholeFile(String fileName) {
        String result = null;
        Stream<String> fileStream = null;

        try {
            fileStream = Files.lines(Paths.get(fileName));
            result = fileStream.collect(joining("\n"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileStream != null) {
                fileStream.close();
            }
        }

        return result;
    }
}
