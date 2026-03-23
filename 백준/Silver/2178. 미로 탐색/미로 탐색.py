from collections import deque

import sys
input = sys.stdin.readline

def main():
    N, M = map(int, input().split())
    visited = [[False] * M for _ in range(N)]
    grid = [list(map(int, input().strip())) for _ in range(N)]

    def bfs():
        queue = deque([(0, 0)])
        visited[0][0] = True
        dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        
        while queue:
            row, col = queue.popleft()
            for dr, dc in dir:
                nr, nc = row + dr, col + dc

                if nr < 0 or nr >= N or nc < 0 or nc >= M: continue
                if grid[nr][nc] == 1 and visited[nr][nc] == False:
                    visited[nr][nc] = True
                    grid[nr][nc] = grid[row][col] + 1
                    queue.append((nr, nc))

    bfs()
    print(grid[N - 1][M - 1])

if __name__ == "__main__":
    main()