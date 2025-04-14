import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> extensionCount = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("\\.");
            String extension = input[1];
            extensionCount.put(extension, extensionCount.getOrDefault(extension, 0) + 1);
        }
        
        Map<String, Integer> sortedExtension = new TreeMap<>(extensionCount);
        
        for (Map.Entry<String, Integer> entry : sortedExtension.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}