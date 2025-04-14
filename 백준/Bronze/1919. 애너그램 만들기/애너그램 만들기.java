import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();

        int[] countA = new int[26];
        int[] countB = new int[26];

        for (char c1 : A.toCharArray()) {
            countA[c1 - 'a']++;
        }

        for (char c2 : B.toCharArray()) {
            countB[c2 - 'a']++;
        }
        
        int diff = 0;
        for (int i =0; i < 26; i++) {
            diff += Math.abs(countA[i] - countB[i]);
        }

        System.out.println(diff);
    }
}