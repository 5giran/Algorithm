import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean minPalindromicPrime = false;

        while (!minPalindromicPrime) {
            String n = String.valueOf(N);
            String reversed = new StringBuilder(n).reverse().toString();
            int count = 0;

            if (n.equals(reversed)) {
                for (int i = 2; i < N; i++) {
                    if (N % i == 0) {

                    } else count += 1;
                }

                if (count == (N - 2)) {
                    minPalindromicPrime = true;
                    System.out.println(N);
                }
            }

            N++;
        }
    }

}
