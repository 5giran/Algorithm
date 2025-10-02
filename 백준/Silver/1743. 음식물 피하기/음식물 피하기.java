import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K, r, c;
    static boolean[][] grid;
    static boolean[][] visited;
    static int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        grid = new boolean[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            grid[r][c] = true;
        }

        List<Integer> garbageCount = new ArrayList<>();

        for (int i = 0; i < N+1; i++) {
            for (int j = 0; j < M+1; j++) {

                if (i < 0 || i >= N+1 || j < 0 || j >= M+1) continue;
                if (visited[i][j] || !grid[i][j]) continue;

                garbageCount.add(findGarbage(i, j));

            }
        }

        Collections.sort(garbageCount, Collections.reverseOrder());
        if (!garbageCount.isEmpty()) {
            System.out.println(garbageCount.get(0));
        } else System.out.println(0);
    }

    public static int findGarbage(int i, int j) {
        int count = 1;
        visited[i][j] = true;

        for (int[] dir : directions) {
            int dI = i + dir[0];
            int dJ = j + dir[1];

            if (dI < 0 || dI >= N+1 || dJ < 0 || dJ >= M+1) continue;
            if (visited[dI][dJ] || !grid[dI][dJ]) continue;

            count += findGarbage(dI, dJ);
        }

        return count;
    }
}
