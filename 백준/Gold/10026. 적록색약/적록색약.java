import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean[][] visited;
    static boolean[][] visitedDal;


    static int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    static void findArea(int row, int col, int N, char[][] area) {
        visited[row][col] = true;

        for (int[] dir : directions) {
            int adjRow = row + dir[0];
            int adjCol = col + dir[1];

            if (adjRow < 0 || adjRow >= N || adjCol < 0 || adjCol >= N) continue;
            if (visited[adjRow][adjCol] || area[row][col] != area[adjRow][adjCol]) continue;

            findArea(adjRow, adjCol, N, area);
        }
    }


    static char[][] daltonism(char[][] area, int N) {
        char[][] daltonism = new char[N][N];

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (area[row][col] == 'R') {
                    daltonism[row][col] = 'G';

                } else daltonism[row][col] = area[row][col];
            }
        }
        return daltonism;
    }



    static void findDaltonismArea(int row, int col, int N, char[][] dal) {
        visitedDal[row][col] = true;

        for (int[] dir : directions) {
            int adjRow = row + dir[0];
            int adjCol = col + dir[1];

            if (adjRow < 0 || adjRow >= N || adjCol < 0 || adjCol >= N) continue;
            if (visitedDal[adjRow][adjCol] || dal[row][col] != dal[adjRow][adjCol]) continue;

            findDaltonismArea(adjRow, adjCol, N, dal);
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());


        char[][] area = new char[N][N];
        visited = new boolean[N][N];


        visitedDal = new boolean[N][N];

        for (int row = 0; row < N; row++) {
            String input = br.readLine();

            for (int col = 0; col < N; col++) {
                area[row][col] = input.charAt(col);
            }
        }

        char[][] dal = daltonism(area, N);

        int areaCount = 0;

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {

                if (visited[row][col]) continue;

                areaCount++;

                findArea(row, col, N, area);
            }
        }


        int daltonismCount = 0;

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {

                if (visitedDal[row][col]) continue;

                daltonismCount++;

                findDaltonismArea(row, col, N, dal);
            }
        }




        sb.append(areaCount).append(' ');
        sb.append(daltonismCount);


        System.out.println(sb);

    }
}