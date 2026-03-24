from collections import deque
from math import nextafter
import sys
input  = sys.stdin.readline

def main():
    n, m = map(int, input().split())
    # visited 배열 이상의 보드 선언 필요 없음

    move = {} # 딕셔너리로 사다리, 뱀 정보 저장
    for _ in range(n + m):
        a, b = map(int, input().split())
        move[a] = b

    # bfs
    visited = [False] * 101
    queue = deque()
    queue.append((1, 0))
    visited[1] = True

    while queue:
        pos, count = queue.popleft()

        if pos == 100: # 도착 조건
            print(count)
            return
        for dice in range(1, 7):
            next_pos = pos + dice
            if next_pos > 100:
                continue # 범위 초과 처리
            
            # 사다리/뱀 체크
            if next_pos in move:
                next_pos = move[next_pos]
            if not visited[next_pos]:
                visited[next_pos] = True
                queue.append((next_pos, count + 1))

if __name__ == "__main__":
    main()        