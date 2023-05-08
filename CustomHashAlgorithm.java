public class CustomHashAlgorithm {

    public static int customHash(String input) {
        int hash = 0;

        for (int i = 0; i < input.length(); i++) {
            hash = (hash ^ input.charAt(i)) + i % 100;
        }

        return hash;
    }

    public static void main(String[] args) {
        String input = "samad";
        int hashValue = customHash(input);

        System.out.println("Input: " + input);
        System.out.println("Hash Value: " + hashValue);
    }
}
