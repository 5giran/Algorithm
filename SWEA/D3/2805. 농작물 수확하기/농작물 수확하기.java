import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static int[][] farm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

        farm = new int[N][N];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    farm[i][j] = line.charAt(j) - '0';
                }
            }
            

            int result = calculateProfit(N);


            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }

        System.out.println(sb);

    }

    private static int calculateProfit(int n) {
        int profit = 0;
        int center = n / 2;

        for (int i = 0; i < n; i++) {
            int dist = Math.abs(i - center);

            int startIndex = dist;
            int endIndex = (n - 1) - dist;

            for (int j = startIndex; j <= endIndex; j++) {
                profit += farm[i][j];
            }
        }

        return profit;
    }
}