import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[][] ingredients;
    static int N, L;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            ingredients = new int[N][2];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                ingredients[i][0] = Integer.parseInt(st.nextToken());
                ingredients[i][1] = Integer.parseInt(st.nextToken());
            }

            max = 0;

            makeBurger(0, 0, 0);

            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }

        System.out.print(sb);
    }


    private static void makeBurger(int index, int scoreSum, int calSum) {

        if (calSum > L) {
            return;
        }

        if (index == N) {
            max = Math.max(max, scoreSum);
            return;
        }

        makeBurger(index + 1, scoreSum + ingredients[index][0], calSum + ingredients[index][1]);


        makeBurger(index + 1, scoreSum, calSum);
    }

}