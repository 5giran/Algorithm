import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int w, h;
    static int[][] grid;
    static boolean[][] visited;

    static int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1},
            {-1, -1},
            {+1, -1},
            {-1, +1},
            {+1, +1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            visited = new boolean[h][w];
            grid = new int[h][w];

            for (int row = 0; row < h; row++) {
                st = new StringTokenizer(br.readLine());
                for (int col = 0; col < w; col++) {
                    grid[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            int islandCount = 0;

            for (int row = 0; row < h; row++) {
                for (int col = 0; col < w; col++) {
                    if (grid[row][col] == 1 && !visited[row][col]) {
                        dfs(row, col);
                        islandCount++;
                    }
                }
            }

            System.out.println(islandCount);
        }
    }

    static void dfs(int row, int col) {
        visited[row][col] = true;

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < h && newCol >= 0 && newCol < w) {
                if (!visited[newRow][newCol] && grid[newRow][newCol] == 1) {
                    dfs(newRow, newCol);
                }
            }
        }
    }

}
