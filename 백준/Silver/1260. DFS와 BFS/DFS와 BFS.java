import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int N, M, V;
    static List<Integer>[] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        
        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }
        
        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();
        
        visited = new boolean[N + 1];
        bfs(V);
        System.out.println();
    }
    
    // DFS 구현
    static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int nxt : adj[v]) {
            if (!visited[nxt]) {
                dfs(nxt);
            }
        }
    }
    
    // BFS 구현
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);
        
        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");
            for (int nxt : adj[v]) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    queue.offer(nxt);
                }
            }
        }
    }
}
