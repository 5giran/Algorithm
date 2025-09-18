import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            int[][] map = new int[M][N];

            for (int j = 0; j < K; j++) {
                StringTokenizer str = new StringTokenizer(br.readLine());
                map[Integer.parseInt(str.nextToken())][Integer.parseInt(str.nextToken())] = 1;
            }

            int worm = 0;
            for (int h = 0; h < M; h++) {
                for (int v = 0; v < N; v++) {
                    if (map[h][v] == 1) {
                        findAdjacent(map, h, v, M, N);
                        worm++;
                    }
                }
            }
            System.out.println(worm);

        }

    }

    static int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    static void findAdjacent(int[][] map, int h, int v, int M, int N) {
        map[h][v] = 0;
        
        for (int[] dir : directions) {
            int adjH = h + dir[0];
            int adjV = v + dir[1];

            if (adjH >= 0 && adjH < M && adjV >= 0 && adjV < N) {
                if (map[adjH][adjV] == 1) {
                    findAdjacent(map, adjH, adjV, M, N);
                }

            }
        }
    }
}