public class KeylessTranspositionCipher {
    public static String encrypt(String plaintext) {
        int numRows = (int) Math.ceil(Math.sqrt(plaintext.length()));
        int numCols = (int) Math.ceil((double) plaintext.length() / numRows);
        char[][] grid = new char[numRows][numCols];

        int index = 0;
        for (int col = 0; col < numCols; col++) {
            for (int row = 0; row < numRows; row++) {
                if (index < plaintext.length()) {
                    grid[row][col] = plaintext.charAt(index);
                    index++;
                } else {
                    grid[row][col] = ' ';
                }
            }
        }

        StringBuilder ciphertext = new StringBuilder();
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                ciphertext.append(grid[row][col]);
            }
        }

        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext) {
        int numRows = (int) Math.ceil(Math.sqrt(ciphertext.length()));
        int numCols = (int) Math.ceil((double) ciphertext.length() / numRows);
        char[][] grid = new char[numRows][numCols];

        int index = 0;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (index < ciphertext.length()) {
                    grid[row][col] = ciphertext.charAt(index);
                    index++;
                } else {
                    grid[row][col] = ' ';
                }
            }
        }

        StringBuilder plaintext = new StringBuilder();
        for (int col = 0; col < numCols; col++) {
            for (int row = 0; row < numRows; row++) {
                plaintext.append(grid[row][col]);
            }
        }

        return plaintext.toString().trim();
    }

    public static void main(String[] args) {
        String plaintext = "priyam";
        String encryptedText = encrypt(plaintext);
        String decryptedText = decrypt(encryptedText);

        System.out.println("Plaintext: " + plaintext);
        System.out.println("Encrypted: " + encryptedText);
        System.out.println("Decrypted: " + decryptedText);
    }
}
