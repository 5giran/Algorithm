import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String input = br.readLine();
            Deque<Character> stack = new ArrayDeque<>();
            boolean isVPS = true;

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);

                if (c == '(') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        isVPS = false;
                        break;
                    }
                    stack.pop();
                }
            }

            System.out.println((isVPS && stack.isEmpty()) ? "YES" : "NO");
        }
    }
}
