import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    // Meeting 구조체 선언, 종료시간 기준으로 오름차순 정렬
    static class Meeting implements Comparable<Meeting> {
        final int start, end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }


        @Override
        public int compareTo(Meeting o) {
            // 1. 종료시간이 같은지 비교
            if (this.end == o.end) {
                // 2. 종료시간이 같다면 시작 시간으로 오름차순 정렬
                return this.start - o.start;
            }

            // 3. 종료시간이 같지 않다면 베이직 로직, 종료시간순으로 오름차순 정렬
            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        ArrayList<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetings.add(new Meeting(start, end));
        }

        Collections.sort(meetings);

        // 진행 가능한 미팅의 개수, 최초값 하나 카운트하고 시작함
        int count = 1;

        int start = meetings.get(0).start;
        int end = meetings.get(0).end;

        for (int i = 1; i < N; i++) {

            // 설정값(초기값)과 비교할 값
            Meeting next = meetings.get(i);

            // 배치할 수 있는 회의인 경우
            if (next.start >= start && next.start >= end) {
                count++;

                start = next.start;
                end = next.end;
            }
        }

        System.out.println(count);

    }
}