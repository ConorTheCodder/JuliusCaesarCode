package org.example;

import lombok.SneakyThrows;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Encrypted {

    @SneakyThrows
    public void encrypted(boolean flag) {

        ConsoleHelper.writeMessage("Введите путь к файлу:");
        String src = ConsoleHelper.readString();
        ConsoleHelper.writeMessage("Введите ключ:");
        int key = ConsoleHelper.readInt();
        Path dst = ConsoleHelper.buildFileName(src, flag ? "_encrypted" : "_decrypted");

        String wholeContent = Files.readString(Path.of(src));
        CaesarCipher caesarCipher = new CaesarCipher();
        Files.writeString(dst, flag ? caesarCipher.encrypt(wholeContent, key) : caesarCipher.decrypt(wholeContent, key));

        /*try (BufferedReader bufferedReader = new BufferedReader(new FileReader(src));
             BufferedWriter bufferedWriter = Files.newBufferedWriter(dst)) {

            CaesarCipher caesarCipher = new CaesarCipher();

            while (bufferedReader.ready()) {
                String string = bufferedReader.readLine();
                String encryptedLine = flag ? caesarCipher.encrypt(string, key) : caesarCipher.decrypt(string, key);
                bufferedWriter.write(encryptedLine);
                bufferedWriter.newLine();
            }

        } catch (IOException ignore) {

        }*/
        ConsoleHelper.writeMessage("Содержимое файла " + (flag ? "зашифровано" : "дешифровано") + " и записано успешно.");
    }
}
