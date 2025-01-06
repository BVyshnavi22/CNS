import java.util.Scanner;

public class SubstitutionCipher {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String process(String text, String key, boolean encrypt) {
        StringBuilder result = new StringBuilder();
        String reference = encrypt ? ALPHABET : key;
        String target = encrypt ? key : ALPHABET;

        for (char c : text.toUpperCase().toCharArray()) {
            int index = reference.indexOf(c);
            result.append(index >= 0 ? target.charAt(index) : c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String text = sc.nextLine();
        System.out.print("Enter the substitution key (26 letters): ");
        String key = sc.nextLine().toUpperCase();

        if (key.length() != 26) {
            System.out.println("Error: Key must be exactly 26 characters.");
            return;
        }

        String encrypted = process(text, key, true);
        String decrypted = process(encrypted, key, false);

        System.out.println("Encrypted Text: " + encrypted);
        System.out.println("Decrypted Text: " + decrypted);
    }
}
