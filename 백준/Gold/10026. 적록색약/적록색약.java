import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static char[][] grid, colorBlindGrid;
    static boolean[][] visited;
    static int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };


    // 같은 구역 방문처리
    static void exploreRegion(int row, int col, int N, char[][] grid) {
        visited[row][col] = true;

        for (int[] dir : directions) {
            int adjRow = row + dir[0];
            int adjCol = col + dir[1];

            if (adjRow < 0 || adjRow >= N || adjCol < 0 || adjCol >= N) continue;
            // 이미 방문했거나 기존 색깔과 인접 부분의 색이 다르면
            if (visited[adjRow][adjCol] || grid[row][col] != grid[adjRow][adjCol]) continue;

            exploreRegion(adjRow, adjCol, N, grid);
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());


        grid = new char[N][N];
        colorBlindGrid = new char[N][N];



        // 그림 정보 입력받기
        for (int row = 0; row < N; row++) {
            String input = br.readLine();

            for (int col = 0; col < N; col++) {
                grid[row][col] = input.charAt(col);
                // 입력받을때 적록색약용 그리드도 입력받음
                colorBlindGrid[row][col] = (grid[row][col] == 'R') ? 'G' : input.charAt(col);
            }
        }


        // 그림을 순회하면서 단지찾기 (비색약인)
        int regionCount = 0;
        visited = new boolean[N][N];

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {

                // 이미 방문했으면 넘어감
                if (visited[row][col]) continue;

                regionCount++;

                // 영역처리 함수로 넘기기
                exploreRegion(row, col, N, grid);
            }
        }


        // 그림을 순회하면서 단지 찾기 (적록색약)
        int colorBlindRegionCount = 0;
        visited = new boolean[N][N];

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {

                // 이미 방문했으면 넘어감
                if (visited[row][col]) continue;

                colorBlindRegionCount++;

                // 영역처리 함수로 넘기기
                exploreRegion(row, col, N, colorBlindGrid);
            }
        }

        sb.append(regionCount).append(' ');
        sb.append(colorBlindRegionCount);

        System.out.println(sb);
    }
}