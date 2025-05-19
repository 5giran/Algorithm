import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] grid;
    static boolean[][] visited;

    static int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N][N];
        grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = line.charAt(j) - '0';
            }
        }


        List<Integer> componentSizes = new ArrayList<>();

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (grid[row][col] == 1 && !visited[row][col]) {
                    int houseCount = dfs(row, col);
                    componentSizes.add(houseCount);
                }
            }

        }

        Collections.sort(componentSizes);
        
        System.out.println(componentSizes.size());
        for (int size : componentSizes) {
            System.out.println(size);
        }


    }

    static int dfs(int row, int col) {
        visited[row][col] = true;
        int houseCount = 1;

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < N) {
                if (!visited[newRow][newCol] && grid[newRow][newCol] == 1) {
                    houseCount += dfs(newRow, newCol);
                }
            }

        }
        return houseCount;

    }
}
