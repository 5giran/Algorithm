import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = 10;
        int N;

        int number = 1;

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            int[] building = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                building[i] = Integer.parseInt(st.nextToken());
            }

            int count = 0;
            // 앞뒤 2개씩은 빼고 루프
            for (int i = 2; i < N - 2; i++) {

                for (int j = 0; j < 999; j++) {
                    if ((building[i] - j) > building[i - 1] && (building[i] - j) > building[i - 2] && (building[i] - j) > building[i + 1] && (building[i] - j) > building[i + 2]) count++;
                    else break;
                }

            }

            bw.write("#" + number + " " + count + "\n");

            number++;
        }

        bw.flush();
        bw.close();
    }
}