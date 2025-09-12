import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] room = new String[N];
        for (int i = 0; i < N; i++) {
            room[i] = br.readLine();
        }

        int horizontal = 0;
        for (int i = 0; i < N; i++) {
            horizontal += countSeats(room[i]);
        }

        int vertical = 0;
        for (int col = 0; col < N; col++) {
            StringBuilder sb = new StringBuilder();
            for (int row = 0; row < N; row++) {
                sb.append(room[row].charAt(col));
            }
            vertical += countSeats(sb.toString());
        }
        System.out.println(horizontal + " " + vertical);

    }

    static int countSeats(String line) {
        Pattern pattern = Pattern.compile("\\.{2,}");
        Matcher matcher = pattern.matcher(line);

        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
