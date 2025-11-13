import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 재료 수
            int L = Integer.parseInt(st.nextToken()); // 제한 칼로리

            // 최대 맛 점수 저장
            int[] dp = new int[L + 1];

            // 재료 갯수만큼 순회 - 모든 재료를 하나씩 순회
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                int cal = Integer.parseInt(st.nextToken());

                // 배낭 문제 핵심 로직
                // 역순으로 순회 - 0/1 백팩 문제라면 무조건
                for (int j = L; j >= cal; j--) {

                    // dp[k]       : 현재 재료를 포함하지 않고, k 칼로리를 채우는 기존의 최대 점수
                    // dp[k - cal] + score : 현재 재료를 포함시키는 경우의 새로운 점수, 포함시켰으므로 그만큼의 칼로리가 빠짐
                    dp[j] = Math.max(dp[j], dp[j - cal] + score);
                }
            }

            sb.append("#").append(tc).append(" ").append(dp[L]).append("\n");
        }

        System.out.println(sb);
    }

}