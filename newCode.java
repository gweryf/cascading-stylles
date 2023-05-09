#Transposition

package CSS;

import java.util.Scanner;

public class transposition_keyless {
        public static void main(String args[]) {
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            StringBuilder s1 = new StringBuilder();
            StringBuilder s2 = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                if(i%2==0){
                    if(s.charAt(i)==' '){
                        s1.append('-');
                    }else
                        s1.append(s.charAt(i));
                }
                else{
                    if(s.charAt(i)==' '){
                        s1.append('-');
                    }else
                        s2.append(s.charAt(i));
                }
            }
            s1.append(s2);
            System.out.println("the encyption text is "+s1);
        }
    }
    
    
    #Ceaser and shift
    
    package CSS;

import java.util.Scanner;

public class ceaser_cipher {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int n = in.nextInt();
        StringBuilder s1 = new StringBuilder();

        for (int i = 0; i <s.length() ; i++) {
            char c = (char) ((((s.charAt(i)-97)+n)%26)+97);
            s1.append(c);
        }
        System.out.println(s1);

        StringBuilder s2 = new StringBuilder();
        for (int i = 0; i <s.length() ; i++) {
            int r = (s1.charAt(i)-97)-n;
            if(r<0) r=r+26;
            char c = (char) ((((r))%26)+97);
            s2.append(c);
        }
        System.out.println(s2);
    }
}
