import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> stack = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            if (command.startsWith("push")) {
                int X = Integer.parseInt(command.split(" ")[1]);
                stack.add(X);
            }

            if (command.startsWith("pop")) {
                if (!stack.isEmpty()) {
                    System.out.println(stack.get(stack.size() - 1));
                    stack.remove(stack.size() - 1);
                } else {
                    System.out.println(-1);
                }
            }

            if (command.startsWith("size")) {
                System.out.println(stack.size());
            }

            if (command.startsWith("empty")) {
                if (stack.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }

            if (command.startsWith("top")) {
                if (!stack.isEmpty()) {
                    System.out.println(stack.get(stack.size() - 1));
                } else {
                    System.out.println(-1);
                }
            }

        }
    }


}