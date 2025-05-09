import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        LinkedList<Integer> queue = new LinkedList<>();

        while (N--> 0) {
            String command = br.readLine();

            if (command.startsWith("push")) {
                int X = Integer.parseInt(command.split(" ")[1]);
                queue.add(X);

            } else if (command.equals("pop")) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.getFirst());
                    queue.removeFirst();
                } else {
                    System.out.println(-1);
                }

            } else if (command.equals("size")) {
                System.out.println(queue.size());

            } else if (command.equals("empty")) {
                System.out.println(queue.isEmpty() ? 1 : 0);
                
            } else if (command.equals("front")) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.getFirst());
                } else {
                    System.out.println(-1);
                }

            } else if (command.equals("back")) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.getLast());
                } else {
                    System.out.println(-1);
                }
            }


        }
    }
}