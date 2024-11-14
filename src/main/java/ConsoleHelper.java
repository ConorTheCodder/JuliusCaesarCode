import lombok.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConsoleHelper {

    private static final BufferedReader CONSOLE = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    @SneakyThrows
    public static String readString(){
        return CONSOLE.readLine();
    }

    public static int readInt(){
        return Integer.parseInt(readString());
    }

    public static Path buildFileName(String path, String suffix){
        return null;
    }

    /*
    Д/З: 1) К адресу файла, который нужно за/дешифровать, нужно добавить суффикс в конец, если нет расширения.
    И до расширения, если оно есть. Расширение заканчивается "точка.текст". Вернуть это в формате Path.

    2) Добавить везде в коде ConsoleHelper
     */
}
