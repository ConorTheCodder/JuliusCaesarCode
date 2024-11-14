import java.io.IOException;
import java.util.Scanner;

//C:\Users\rush7\IdeaProjects\JuliusCaesarCode\src\resources\1.txt
//C:\Users\rush7\IdeaProjects\JuliusCaesarCode\src\resources\1_e.txt
//C:\Users\rush7\IdeaProjects\JuliusCaesarCode\src\resources\1_e_d.txt
public class Menu {

    public static void main(String[] args) throws IOException {


        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("""
                Выберите действие, введя его номер:\s
                1. Зашифровать текст в файле с помощью ключа.\s
                2. Расшифровать текст в файле с помощью ключа.\s
                3. Подобрать ключ к зашифрованному тексту в файле (brute force).\s
                4. Расшифровать текст в файле методом синтаксического анализа текста.\s
                5. Выход из программы.""");

        int enterNumber = scanner.nextInt();

            if (enterNumber == 1) {
                new EncryptedDecrypted().encryptedDecrypted(true);
            }
            else if (enterNumber == 2) {
                new EncryptedDecrypted().encryptedDecrypted(false);

            }
            else if (enterNumber == 3) {
                System.out.println();
            }
            else if (enterNumber == 4) {
                System.out.println();
            }
            else if(enterNumber == 5) {
                break;
            }
        }

    }
}
