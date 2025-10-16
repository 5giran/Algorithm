import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] leakPoint = new int[n];
        for (int i = 0; i < n; i++) {
            leakPoint[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(leakPoint);

        int tapeStartPoint = leakPoint[0];
        int tapeCount = 1;
        for (int i = 0; i < n; i++) {
            if (leakPoint[i] - tapeStartPoint + 1 <= l) {
                continue;
            }

            tapeCount++;
            tapeStartPoint = leakPoint[i];
        }

        System.out.println(tapeCount);

    }
}