import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for (int tc = 1; tc <= 10; tc++) {
            int dump = Integer.parseInt(br.readLine());

            // 1-100까지 카운트 입력
            int[] count = new int[101];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++) {
                // if (!st.hasMoreTokens()) break;
                int input = Integer.parseInt(st.nextToken());

                count[input]++;
            }

            // 현재 가장 낮은 높이, 높은 높이 포인터
            int min = 1;
            int max = 100;


            // 덤프 실행
            for (int i = 0; i < dump; i++) {
                // 데이터가 있는 경우 바로 최소값과 최대값임
                while (count[min] == 0) min++;
                while (count[max] == 0) max--;

                // 평탄화 완료 시 즉시종료
                if (max - min <= 1) break;

                count[max]--; // 가장 높은 높이 상자 하나 줄어듬
                count[max - 1]++; // 위의 그 상자는 -1상자에 추가됨
                count[min]--;
                count[min + 1]++;
            }

            while (count[min] == 0) min++;
            while (count[max] == 0) max--;

            int result = max - min;

            System.out.println("#" + tc + " " + result);

        }
    }
}