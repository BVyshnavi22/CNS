import java.util.Scanner;

public class AutoKeyCipher {

    // Encrypt plaintext
    public static String encrypt(String text, String key) {
        text = text.toUpperCase();
        key = key.toUpperCase();

        StringBuilder extendedKey = new StringBuilder(key);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length() - key.length(); i++)
            extendedKey.append(text.charAt(i));

        for (int i = 0; i < text.length(); i++) {
            char t = text.charAt(i), k = extendedKey.charAt(i);
            result.append((char)(((t - 'A') + (k - 'A')) % 26 + 'A'));
        }
        return result.toString();
    }

    // Decrypt ciphertext
    public static String decrypt(String text, String key) {
        text = text.toUpperCase();
        key = key.toUpperCase();

        StringBuilder result = new StringBuilder(key);
        for (int i = 0; i < text.length(); i++) {
            char t = text.charAt(i), k = result.charAt(i);
            result.append((char)(((t - 'A') - (k - 'A') + 26) % 26 + 'A'));
        }
        return result.substring(key.length());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter plaintext: ");
        String plaintext = scanner.nextLine();
        System.out.print("Enter key: ");
        String key = scanner.nextLine();

        String ciphertext = encrypt(plaintext, key);
        System.out.println("Ciphertext: " + ciphertext);
        System.out.println("Decrypted Text: " + decrypt(ciphertext, key));
        scanner.close();
    }
}
