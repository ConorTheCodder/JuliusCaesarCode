import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BruteForce {

    @SneakyThrows
    public void bruteForce() {

        ConsoleHelper.writeMessage("Введите путь к файлу: ");
        String src = ConsoleHelper.readString();
        Path dest = ConsoleHelper.buildFileName(src, "_bruteforce");

        CaesarCipher caesarCipher = new CaesarCipher();

        try (BufferedReader reader = Files.newBufferedReader(Path.of(src));) {
            String line = reader.readLine();
            for (int i = 0; i < caesarCipher.getAlphabetLength(); i++) {
                String decrypted = caesarCipher.decrypt(line, i);
                if (isValidated(decrypted)) {
                    ConsoleHelper.writeMessage("Ключ найден: " + i);
                }
            }
        }
    }

    private boolean isValidated(String text) {
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
