import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        LinkedList<Integer> cardSet = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            cardSet.add(i);
        }

        while (cardSet.size() > 1) {
            cardSet.removeFirst();
            int next = 0;
            next = cardSet.getFirst();
            cardSet.addLast(next);
            cardSet.removeFirst();
        }

        System.out.println(cardSet.getFirst());

    }
}