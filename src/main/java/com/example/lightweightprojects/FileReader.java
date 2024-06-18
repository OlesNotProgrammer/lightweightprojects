package com.example.lightweightprojects;

import static java.util.stream.Collectors.joining;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

public class FileReader {
    public static String readWholeFile(String fileName) {
        Path filePath;

        try {
            filePath = createPathFromFileName(fileName);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        try (Stream<String> fileLinesStream = openFileLinesStream(filePath)) {
            return fileLinesStream.collect(joining("\n"));
        }
    }

    private static Path createPathFromFileName(String fileName) throws URISyntaxException {
        Objects.requireNonNull(fileName);
        URL fileUrl = FileReader.class.getClassLoader().getResource(fileName);
        try {
            return Paths.get(fileUrl.toURI());
        } catch (URISyntaxException e) {
            throw e;
        }
    }

    private static Stream<String> openFileLinesStream(Path filePath) throws IOException {
        try {
            return Files.lines(filePath);
        } catch (IOException e) {
            throw e;
        }
    }
}
