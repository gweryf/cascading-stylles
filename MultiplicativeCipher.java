public class MultiplicativeCipher {
    private static final int ALPHABET_SIZE = 26;
    private static final int MULTIPLIER = 7;

    public static String encrypt(String plaintext) {
        StringBuilder ciphertext = new StringBuilder();

        for (char c : plaintext.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                int offset = (c - base) * MULTIPLIER % ALPHABET_SIZE;
                char encryptedChar = (char) (base + offset);
                ciphertext.append(encryptedChar);
            } else {
                ciphertext.append(c);
            }
        }

        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext) {
        // Calculate the modular inverse of the multiplier
        int inverseMultiplier = -1;
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if ((MULTIPLIER * i) % ALPHABET_SIZE == 1) {
                inverseMultiplier = i;
                break;
            }
        }

        StringBuilder plaintext = new StringBuilder();

        for (char c : ciphertext.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                int offset = (c - base) * inverseMultiplier % ALPHABET_SIZE;
                char decryptedChar = (char) (base + offset);
                plaintext.append(decryptedChar);
            } else {
                plaintext.append(c);
            }
        }

        return plaintext.toString();
    }

    public static void main(String[] args) {
        String plaintext = "lmao";        
        String encryptedText = encrypt(plaintext);
        String decryptedText = decrypt(encryptedText);

        System.out.println("Plaintext: " + plaintext);
        System.out.println("Encrypted: " + encryptedText);
        System.out.println("Decrypted: " + decryptedText);
    }
}
