package org.example;

import lombok.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConsoleHelper {

    private static final BufferedReader CONSOLE = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    @SneakyThrows
    public static String readString() {
        return CONSOLE.readLine();
    }

    public static int readInt() {
        return Integer.parseInt(readString());
    }

    public static Path buildFileName(String path, String suffix) {
        Path fullPath = Paths.get(path);
        String fileName = fullPath.getFileName().toString();
        if (!fileName.contains(".")) {
            return Path.of(path + suffix);
        }
        int dotIndex = fileName.lastIndexOf(".");
        String left = fileName.substring(0, dotIndex);
        String right = fileName.substring(dotIndex);
        String result = left + suffix + right;
        return fullPath.getParent().resolve(result);
    }
}