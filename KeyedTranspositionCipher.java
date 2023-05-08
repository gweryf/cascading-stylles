public class KeyedTranspositionCipher {
    public static String encrypt(String plaintext, String key) {
        int numCols = key.length();
        int numRows = (int) Math.ceil((double) plaintext.length() / numCols);
        char[][] grid = new char[numRows][numCols];

        int index = 0;
        for (char c : plaintext.toCharArray()) {
            grid[index / numCols][index % numCols] = c;
            index++;
        }

        StringBuilder ciphertext = new StringBuilder();
        for (int col = 0; col < numCols; col++) {
            for (int row = 0; row < numRows; row++) {
                ciphertext.append(grid[row][col]);
            }
        }

        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, String key) {
        int numCols = key.length();
        int numRows = (int) Math.ceil((double) ciphertext.length() / numCols);
        char[][] grid = new char[numRows][numCols];

        int index = 0;
        for (char c : ciphertext.toCharArray()) {
            grid[index % numRows][index / numRows] = c;
            index++;
        }

        StringBuilder plaintext = new StringBuilder();
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                plaintext.append(grid[row][col]);
            }
        }

        return plaintext.toString().trim();
    }

    public static void main(String[] args) {
        String plaintext = "Hello, World!";
        String key = "KEY";

        String encryptedText = encrypt(plaintext, key);
        String decryptedText = decrypt(encryptedText, key);

        System.out.println("Plaintext: " + plaintext);
        System.out.println("Key: " + key);
        System.out.println("Encrypted: " + encryptedText);
        System.out.println("Decrypted: " + decryptedText);
    }
}
