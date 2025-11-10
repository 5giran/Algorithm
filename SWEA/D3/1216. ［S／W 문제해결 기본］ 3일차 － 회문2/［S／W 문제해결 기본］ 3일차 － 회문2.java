import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static final int N = 100;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < 10; tc++) {
            int number = Integer.parseInt(br.readLine());
            board = new char[N][N];

            for (int r = 0; r < N; r++) {
                String line = br.readLine();
                for (int c = 0; c < N; c++) {
                    board[r][c] = line.charAt(c);
                }
            }

            int max = 1;
            // 회문 최댓값 판별
            for (int l = N; l >= 1; l--) {
                if (checkingBoard(l)) {
                    max = l;
                    break; // 최대길이 찾았으니 즉시 종료
                }
            }

            sb.append("#").append(number).append(" ").append(max).append("\n");

        }

        System.out.print(sb);
    }

    private static boolean checkRowPalindrome(int r, int cStart, int L) {

        for (int i = 0; i < L / 2; i++) {
            if (board[r][cStart + i] != board[r][cStart + L - 1 - i]) {
                return false; // 하나라도 일치하지 않으면 false 반환
            }
        }
        return true; // 루프를 전부 통과하면 true 반환

    }

    private static boolean checkColPalindrome(int c, int rStart, int L) {
        for (int i = 0; i < L / 2; i++) {
            if (board[rStart + i][c] != board[rStart + L - 1 - i][c]) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkingBoard(int L) {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c <= N - L; c++) {
                if (checkRowPalindrome(r, c, L)) return true;
            }
        }

        for (int r = 0; r <= N - L; r++) {
            for (int c = 0; c < N; c++) {
                if (checkColPalindrome(c, r, L)) return true;
            }
        }
        return false;
    }

}