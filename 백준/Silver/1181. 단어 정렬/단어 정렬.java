import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        Set<String> wordSet = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            wordSet.add(br.readLine());
        }
        
        List<String> wordList = new ArrayList<>(wordSet);
        
        Collections.sort(wordList, (a,b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                return a.compareTo(b);
            }
        });
        
        for (String word : wordList) {
            System.out.println(word);
        }
    }
}