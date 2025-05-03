import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        ArrayList<Character> stack = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            boolean isVPS = true;
            stack.clear();

            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);

                if (c == '(') {
                    stack.add(c);
                }

                else if (c == ')') {

                    if (!stack.isEmpty()) {
                        stack.remove(stack.size() - 1);
                    } else {
                        isVPS = false;
                        break;
                    }
                }



            }
            if (isVPS == false || !stack.isEmpty()) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }

        }

    }
}