package org.example;

import java.io.IOException;

//C:\Users\rush7\IdeaProjects\JuliusCaesarCode\src\resources\1.txt
//C:\Users\rush7\IdeaProjects\JuliusCaesarCode\src\resources\1_e.txt
//C:\Users\rush7\IdeaProjects\JuliusCaesarCode\src\resources\1_e_d.txt
public class Menu {

    public static void main(String[] args) throws IOException {

        while (true) {

            ConsoleHelper.writeMessage("""
                    Выберите действие, введя его номер:\s
                    1. Зашифровать текст в файле с помощью ключа.\s
                    2. Расшифровать текст в файле с помощью ключа.\s
                    3. Подобрать ключ к зашифрованному тексту в файле (brute force).\s
                    4. Расшифровать текст в файле методом синтаксического анализа текста.\s
                    5. Выход из программы.""");

            int enterNumber = ConsoleHelper.readInt();

            if (enterNumber == 1) {
                new Encrypted().encrypted(true);
            } else if (enterNumber == 2) {
                new Encrypted().encrypted(false);

            } else if (enterNumber == 3) {
                BruteForce bruteForce = new BruteForce();
                bruteForce.bruteForce();
            } else if (enterNumber == 4) {
                System.out.println();
            } else if (enterNumber == 5) {
                break;
            }
        }

    }
}
