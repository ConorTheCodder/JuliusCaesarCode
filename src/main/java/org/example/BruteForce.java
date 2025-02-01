package org.example;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.example.ConsoleHelper.*;

public class BruteForce {

    public static final int MAX_WORD_LENGTH = 28;
    public static final int TEXT_SAMPLE_LENGTH = 200;

    @SneakyThrows
    public void bruteForce() {

        writeMessage("Введите путь к файлу: ");
        String src = readString();
        Path dest = buildFileName(src, "_bruteforce");

        CaesarCipher caesarCipher = new CaesarCipher();

        try (BufferedWriter writer = Files.newBufferedWriter(dest)) {

            List<String> allStrings = Files.readAllLines(Path.of(src));

            for (int i = 0; i < caesarCipher.getAlphabetLength(); i++) {
                String decrypted = caesarCipher.decrypt(String.join("", allStrings), i);
                if (isValidated(decrypted)) {
                    for (String string : allStrings) {
                        String decrypt = caesarCipher.decrypt(string, i);
                        writer.write(decrypt);
                        writer.newLine();
                    }
                    writeMessage("Ключ найден: " + i);
                    break;
                }
            }
        }
    }

    private boolean isValidated(String text) {
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > MAX_WORD_LENGTH) {
                return false;
            }
        }

        boolean isProbablyValidated = false;

        if (text.contains("! ") || text.contains("? ") || text.contains(". ") ||
                text.contains(": ") || text.contains(", ")) {
            isProbablyValidated = true;
        }

        while (isProbablyValidated) {

            writeMessage(text.length() < TEXT_SAMPLE_LENGTH ? text : text.substring(0, TEXT_SAMPLE_LENGTH));
            writeMessage("Читабельный ли данный отрывок текста? (Yes or No)");
            String answer = readString();
            if (answer.equalsIgnoreCase("yes")) {
                return true;
            } else if (answer.equalsIgnoreCase("no")) {
                isProbablyValidated = false;
            } else {
                writeMessage("Введите либо Yes, либо No");
            }
        }

        return false;
    }
}

    /*
    Д/З: 1) Считать весь документ, а не одну строчку (считать всё содержимое документа в одну переменную, выполнить decrypt)
    2) Найти способ понять является ли текст валидным
    3) Взять весь текст, разбить его по пробелам, если есть хоть одно слово длиннее 28 символов- это ключ не подходит
    4) Проверить, что в конце каждого слова есть определенный набор символов (;:.,!? + пробел)
    5) После двух проверок можно ОДИН раз спросить у пользователя, является текст расшифрованным
     */
