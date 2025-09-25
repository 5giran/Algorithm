import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int[][] map; // 지도 배열 (0: 집없음, 1: 집있음)
    static boolean[][] visited; // 방문 여부 체크 배열

    // 인접 좌표 정의
    static int[][] directions = {
            {-1, 0},  // 위로 한 칸
            {1, 0},   // 아래로 한 칸
            {0, -1},  // 왼쪽으로 한 칸
            {0, 1}    // 오른쪽으로 한 칸
    };

    // 단지 확인하고 단지 내 집 개수 세는 함수
    static int findComplexSize(int row, int col, int mapSize) {
        // 현재 위치 방문 처리
        visited[row][col] = true;
        // 집 개수 세기
        int count = 1;

        // 현재 위치에서 연결된 집 탐색
        for (int[] dir : directions) {
            int adjRow = row + dir[0];
            int adjCol = col + dir[1];

            // 경계를 벗어나면 다음 방향으로 넘어감
            if (adjRow < 0 || adjRow >= mapSize || adjCol < 0 || adjCol >= mapSize) continue;
            // 이미 방문했거나 집이 없으면 다음 방향으로 넘어감
            if (visited[adjRow][adjCol] || map[adjRow][adjCol] == 0) continue;

            // 조건을 만족하면 재귀호출하고 재귀호출한걸 누적 더하기
            count += findComplexSize(adjRow, adjCol, mapSize);
        }

        return count;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 지도 크기 mapSize 입력받기
        int mapSize = Integer.parseInt(br.readLine());

        // 배열 초기화
        map = new int[mapSize][mapSize];
        visited = new boolean[mapSize][mapSize];

        // map 지도 배열 입력받기
        for (int row = 0; row < mapSize; row++) {
            String input = br.readLine();

            for (int col = 0; col < mapSize; col++) {
                // 0을 빼주어 int형으로 변환
                map[row][col] = input.charAt(col) - '0';
            }
        }

        // 전체 단지 개수 카운트
        int complexCount = 0;
        // 집 개수 출력용
        List<Integer> complexSizes = new ArrayList<>();

        // 전체 지도를 순회하면서 연결된 집 그룹, 단지 찾기
        for (int row = 0; row < mapSize; row++) {
            for (int col = 0; col < mapSize; col++) {
                // 이미 방문했거나 집이 없으면 넘어감
                if (visited[row][col] || map[row][col] == 0) continue;

                // 새로운 집 단지 발견!
                complexCount++;
                // 주변 집 처리
                complexSizes.add(findComplexSize(row, col, mapSize));

            }
        }

        Collections.sort(complexSizes);

        sb.append(complexCount).append('\n');

        for (int size : complexSizes) {
            sb.append(size).append('\n');
        }

        System.out.print(sb);


    }
}