import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = 100;
        int[][] arr = new int[N][N];

        for (int tc = 0; tc < 10; tc++) {
            int num = Integer.parseInt(br.readLine());

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;

            // 행, 열
            for (int i = 0; i < N; i++) {
                int sumRow = 0;
                int sumCol = 0;
                for (int j = 0; j < N; j++) {
                    sumRow += arr[i][j];
                    sumCol += arr[j][i];
                }

                int sumM = Math.max(sumRow, sumCol);
                if (max < sumM) max = sumM;
            }

            int sumLeft = 0;
            // 왼쪽 시작 대각선
            for (int i = 0; i < N; i++) {
                sumLeft += arr[i][i];
            }

            int sumRight = 0;
            // 오른쪽 시작 대각선
            for (int i = 0; i < N; i++) {
                for (int j = N - 1; j <= 0; j--) {
                    sumRight += arr[i][j];
                }
            }

            int sumM = Math.max(sumLeft, sumLeft);
            if (max < sumM) max = sumM;

            sb.append("#").append(num).append(" ").append(max).append("\n");
        }

        System.out.print(sb);
    }
}