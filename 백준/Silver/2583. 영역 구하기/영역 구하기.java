import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int m, n, k;
    static boolean[][] arr;
    static boolean[][] zone;

    static int extentCount = 0;

    public static void setRectangle(int x1, int y1, int x2, int y2) {
        for (int x = x1; x < x2; x++) {
            for (int y = y1; y < y2; y++) {
                int row = (m - 1) - y;
                int col = x;
                arr[row][col] = true;
            }
        }
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static int dfs(int x, int y) {
        extentCount = 1;
        zone[x][y] = true;

        for (int l = 0; l < 4; l++) {
            int mx = x + dx[l];
            int my = y + dy[l];

            if (mx < 0 || mx >= m || my < 0 || my >= n) continue;
            if (arr[mx][my] || zone[mx][my]) continue;

            extentCount += dfs(mx, my);
        }
        return extentCount;
    }




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new boolean[m][n];
        zone = new boolean[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            setRectangle(x1, y1, x2, y2);
        }

        int zoneCount = 0;
        List<Integer> zoneExtent = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] || zone[i][j]) continue;

                zoneCount++;
                zoneExtent.add(dfs(i, j));
            }
        }

        System.out.println(zoneCount);

        Collections.sort(zoneExtent);

        for (int z : zoneExtent) {
            System.out.print(z + " ");
        }
    }
}