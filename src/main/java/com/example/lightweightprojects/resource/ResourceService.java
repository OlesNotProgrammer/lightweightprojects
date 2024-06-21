package com.example.lightweightprojects.resource;

import static java.util.stream.Collectors.joining;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

@Service
public class ResourceService {
    private final String path = "src/main/resources/client/";

    public String read(String file) {
        String result = null;
        Stream<String> fileStream = null;

        try {
            fileStream = Files.lines(Paths.get(path + file));
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

    public String readPath(String path, String file) {
        return read(path + file);
    }
}
