import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class EncryptedDecrypted {

    public void encryptedDecrypted(boolean flag) {

        System.out.println("Введите путь к файлу:");
        Scanner scanner = new Scanner(System.in);
        String src = scanner.nextLine();
        System.out.println("Введите ключ:");
        int key = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите путь для записи файла:");
        String dst = scanner.nextLine();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(src));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(dst))) {

            CaesarCipher caesarCipher = new CaesarCipher();

            while (bufferedReader.ready()) {
                String string = bufferedReader.readLine();
                String encryptedLine = flag ? caesarCipher.encrypt(string, key) : caesarCipher.decrypt(string, key);
                bufferedWriter.write(encryptedLine);
                bufferedWriter.newLine();
            }

        } catch (IOException ignore) {

        }
        System.out.println("Содержимое файла " + (flag ? "зашифровано" : "дешифровано") + " и записано успешно.");


    }
}
