import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String line = br.readLine();

            String[] words = line.split(" ");
            StringBuilder sb = new StringBuilder();

            for (String word : words) {
                sb.append(new StringBuilder(word).reverse())
                        .append(" ");
            }

            System.out.println(sb.toString().trim());
        }
    }
}