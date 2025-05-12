import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> cardSet = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            cardSet.add(i);
        }

        while (cardSet.size() > 1) {
            cardSet.pollFirst();
            cardSet.addLast(cardSet.pollFirst());
        }

        System.out.println(cardSet.peek());


    }
}