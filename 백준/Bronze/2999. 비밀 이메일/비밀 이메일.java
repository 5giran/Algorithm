import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();

        int R = 1;
        for (int r = 1; r * r <= n; r++) {
            if ((n % r == 0) && (r <= n/r)) {
                R = r;
            }
        }
        int C = n / R;

        char[][] m = new char[R][C];
        int idx = 0;
        for (int col = 0; col < C; col++) {
            for (int row = 0; row < R; row++) {
                m[row][col] = s.charAt(idx++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                sb.append(m[row][col]);
            }
        }

        System.out.println(sb.toString());
    }
}
