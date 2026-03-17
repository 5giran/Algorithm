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

            } else if (command.equals("pop")) {
                if (!stack.isEmpty()) {
                    System.out.println(stack.get(stack.size() - 1));
                    stack.remove(stack.size() - 1);
                } else {
                    System.out.println(-1);
                }

            } else if (command.equals("size")) {
                System.out.println(stack.size());

            } else if (command.equals("empty")) {
                System.out.println(stack.isEmpty() ? 1 : 0);

            } else if (command.equals("top")) {
                if (!stack.isEmpty()) {
                    System.out.println(stack.get(stack.size() - 1));
                } else {
                    System.out.println(-1);
                }
            }



        }
    }


}