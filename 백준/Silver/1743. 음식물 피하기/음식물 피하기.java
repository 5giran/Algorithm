import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
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
        int K = Integer.parseInt(st.nextToken()); // 음식물 개수

        // 배열 초기화
        // 0-indexed, 입력 시 -1
        grid = new boolean[N][M];
        visited = new boolean[N][M];

        // 음식물 좌표 K개 입력
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1; // ⭐ 1-indexed → 0-indexed 변환
            int c = Integer.parseInt(st.nextToken()) - 1;

            grid[r][c] = true;
        }

        // 최대값 저장하는 변수
        int max = 0;

        // 음식물 덩어리 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (visited[i][j] || !grid[i][j]) continue;
                
                max = Integer.max(max, getGarbageSize(i, j));
            }
        }

        System.out.println(max);

    }

    public static int getGarbageSize(int x, int y) {
        int count = 1;
        visited[x][y] = true;

        for (int[] dir : directions) {
            int adjX = x + dir[0];
            int adjY = y + dir[1];

            if (adjX < 0 || adjX >= N || adjY < 0 || adjY >= M) continue;
            if (visited[adjX][adjY] || !grid[adjX][adjY]) continue;

            count += getGarbageSize(adjX, adjY);
        }

        return count;
    }
}