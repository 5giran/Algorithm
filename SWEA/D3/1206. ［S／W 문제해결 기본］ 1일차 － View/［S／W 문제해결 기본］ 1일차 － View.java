import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = 10;

        int number = 1;

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] building = new int[N];
            int view = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N - 1; i++) {
                building[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 2; i < N - 2; i++) {

                if (building[i] > building[i - 1] && building[i] > building[i - 2] && building[i] > building[i + 1] && building[i] > building[i + 2]) {
                    int maxLeft = Math.max(building[i - 1], building[i - 2]);
                    int maxRight = Math.max(building[i + 1], building[i + 2]);
                    int maxTotal = Math.max(maxLeft, maxRight);
                    view += building[i] - maxTotal;
                }

            }

            bw.write("#" + number + " " + view + "\n");

            number++;


        }

        bw.flush();
        bw.close();
    }
}