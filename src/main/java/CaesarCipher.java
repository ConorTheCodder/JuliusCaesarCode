public class CaesarCipher {

    private static final String ALPHABET =
            "abcdefghijklmnopqrstuvwxyz" +
                    "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                    "абвгдеёжзийклмнопрстуфхцчшщъыьэюя" +
                    "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ" +
                    ".,\":!? +-*/\\@#$%^&(){}[];'|`~=_©«»—" +
                    "0123456789";


    public String encrypt(String message, int shiftKey) {

        StringBuilder builder = new StringBuilder();
        for (char aChar : message.toCharArray()) {
            int index = ALPHABET.indexOf(aChar);
            if (index >= 0) {
                int newIndex = (index + shiftKey) % ALPHABET.length();
                char charAt;
                if (newIndex < 0) {
                    charAt = ALPHABET.charAt(ALPHABET.length() + newIndex);
                } else {
                    charAt = ALPHABET.charAt(newIndex);
                }
                builder.append(charAt);
            }
        }

        return builder.toString();
    }

    public String decrypt(String message, int shiftKey) {
        return encrypt(message, shiftKey * -1);
    }

    public int getAlphabetLength() {
        return ALPHABET.length();
    }
}



