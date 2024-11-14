import java.io.*;
import java.util.Scanner;

public class Encrypted {

    public void encrypted() throws IOException {
        /** Задание: запросить у пользователя путь к файлу для его зашифровки.
         * Запросить у пользователя ключ шифрования (shiftKey)
         * Запросить у пользователя путь к файлу куда записать результат
         * Воспользовавшись Цезарем, реализовать зашифровку файла
         * По аналогии реализовать (в отдельном файле, класс Decrypted) сделать то же самое
         */

        System.out.println("Введите путь к файлу:");
        Scanner scanner = new Scanner(System.in);
        String src = scanner.nextLine();
        System.out.println("Введите ключ для зашифровки файла:");
        int key = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите путь для записи файла:");
        String dst = scanner.nextLine();

        FileReader fileReader = new FileReader(src);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        FileWriter fileWriter = new FileWriter(dst);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        CaesarCipher caesarCipher = new CaesarCipher();

        while (bufferedReader.ready()) {
            String string = bufferedReader.readLine();
            String encryptedLine = caesarCipher.encrypt(string, key);
            bufferedWriter.write(encryptedLine);
            bufferedWriter.newLine();
        }

        System.out.println("Содержимое файла зашифровано и записано успешно.");
    }
}
