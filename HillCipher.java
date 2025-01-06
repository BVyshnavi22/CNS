import java.util.Scanner;

public class HillCipher {
    public static int[][] createKeyMatrix(String key, int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0, k = 0; i < size; i++)
            for (int j = 0; j < size; j++, k++)
                matrix[i][j] = key.charAt(k) % 65;
        return matrix;
    }

    public static String encrypt(String text, int[][] keyMatrix, int size) {
        int[] textVector = text.chars().map(c -> c % 65).toArray();
        StringBuilder cipherText = new StringBuilder();

        for (int i = 0; i < size; i++) {
            int cipherChar = 0;
            for (int j = 0; j < size; j++)
                cipherChar += keyMatrix[i][j] * textVector[j];
            cipherText.append((char) (cipherChar % 26 + 65));
        }
        return cipherText.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the key (perfect square length): ");
        String key = sc.nextLine().toUpperCase();
        int size = (int) Math.sqrt(key.length());
        if (size * size != key.length()) {
            System.out.println("Error: Invalid key length.");
            return;
        }

        System.out.print("Enter plaintext (length = key size): ");
        String text = sc.nextLine().toUpperCase();
        if (text.length() != size) {
            System.out.println("Error: Text length mismatch.");
            return;
        }

        System.out.println("Encrypted Text: " + encrypt(text, createKeyMatrix(key, size), size));
    }
}
