import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // x, y좌표 저장 배열
        int [][] points = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            points[i][0] = Integer.parseInt(input[0]); // x 좌표
            points[i][1] = Integer.parseInt(input[1]); // y 좌표
        }

        // 정렬
        Arrays.sort(points, (a, b) -> {
            // x좌표 값이 같을 경우
            if (a[0] == b[0]) {
                // y좌표 값 기준 오름차순으로 정렬
                return Integer.compare(a[1], b[1]);
            }
            // x좌표 값이 다를 경우 x좌표 값 기준 오름차순으로 정렬
            return Integer.compare(a[0], b[0]);
        });

        // 빠른 출력 - 모아서
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(points[i][0]).append(" ").append(points[i][1]).append("\n");
        }
        System.out.println(sb);
    }
}