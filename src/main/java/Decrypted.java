import java.io.*;
import java.util.Scanner;

public class Decrypted {

    public void decrypted() throws IOException {


        System.out.println("Введите путь к файлу:");
        Scanner scanner = new Scanner(System.in);
        String src = scanner.nextLine();
        System.out.println("Введите ключ для расшифровки файла:");
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
            String decryptedLine = caesarCipher.decrypt(string, key);
            bufferedWriter.write(decryptedLine);
            bufferedWriter.newLine();
        }

        System.out.println("Содержимое файла расшифровано и записано успешно.");
    }
}
