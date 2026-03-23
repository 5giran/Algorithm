import sys
input = sys.stdin.readline

def main():
    n = int(input())
    e = int(input())

    network = [[] for _ in range(n+1)]
    for _ in range(e):
        u, v = map(int, input().split())
        network[u].append(v)
        network[v].append(u)

    visited = [False] * (n+1)
    visited[1] = True
    def dfs(node):
        for next_node in network[node]:
            if not visited[next_node]:
                visited[next_node] = True
                dfs(next_node)

    dfs(1)
    result = visited.count(True) - 1
    print(result)

if __name__ == "__main__":
    main()