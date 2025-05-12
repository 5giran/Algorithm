import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        while (N-- > 0) {
            String command = br.readLine();

            // [1] push_front
            if (command.startsWith("push_front")) {
                int X = Integer.parseInt(command.split(" ")[1]);
                deque.addFirst(X); // 덱 앞에 삽입

                // [2] push_back
            } else if (command.startsWith("push_back")) {
                int X = Integer.parseInt(command.split(" ")[1]);
                deque.addLast(X); // 덱 뒤에 삽입

                // [3] pop_front
            } else if (command.equals("pop_front")) {
                if (!deque.isEmpty()) {
                    System.out.println(deque.pollFirst());
                } else {
                    System.out.println(-1);
                }

                // [4] pop_back
            } else if (command.equals("pop_back")) {
                if (!deque.isEmpty()) {
                    System.out.println(deque.pollLast());
                } else {
                    System.out.println(-1);
                }

                // [5] size
            } else if (command.equals("size")) {
                System.out.println(deque.size());

                // [6] empty
            } else if (command.equals("empty")) {
                System.out.println((deque.isEmpty()) ? 1 : 0);

                // [7] front
            } else if (command.equals("front")) {
                if (!deque.isEmpty()) {
                    System.out.println(deque.peekFirst());
                } else {
                    System.out.println(-1);
                }

                // [8] back
            } else if (command.equals("back")) {
                if (!deque.isEmpty()) {
                    System.out.println(deque.peekLast());
                } else {
                    System.out.println(-1);
                }
            }


        }

    }
}