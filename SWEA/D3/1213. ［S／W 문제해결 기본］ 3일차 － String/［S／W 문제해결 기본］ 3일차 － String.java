import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());

            String word = br.readLine();
            String input = br.readLine();

            int count = 0;
            for (int j = 0; j < input.length(); j++) {
                if (j + word.length() > input.length()) break;
                if (word.equals(input.substring(j, j + word.length()))) count++;
            }

            bw.write("#" + num + " " + count);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}