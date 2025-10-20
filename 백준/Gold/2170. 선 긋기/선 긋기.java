import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] points = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(points, (Comparator.comparingInt(o -> o[0])));

        int min = points[0][0];
        int max = points[0][1];

        
        int result = 0;


        for (int i = 1; i < n; i++) {
            if ((min > points[i][0] && min > points[i][1]) || (max < points[i][0] && max < points[i][1])) {

                // 선이 끊김. 지금까지 합쳐진 선의 길이 더하기
                result += max - min;

                // 현재 값으로 새로 시작하기
                min = points[i][0];
                max = points[i][1];

            } else {
                if (points[i][0] < min) min = points[i][0];
                if (points[i][1] > max) max = points[i][1];
            }
        }

        result += max - min;



        System.out.println(result);

    }
}