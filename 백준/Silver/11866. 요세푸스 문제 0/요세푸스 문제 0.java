import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        // 1부터 - N도 입력 되어야 함
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        List<Integer> josephus = new ArrayList<>();

        while (!deque.isEmpty()) {
            for (int i = 1; i < K; i++) {
                deque.addLast(deque.pollFirst());
            }
            josephus.add(deque.pollFirst());
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < josephus.size(); i++) {
            sb.append(josephus.get(i));
            if (i != josephus.size() - 1) sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}