from collections import deque

import sys
input = sys.stdin.readline

def main():
    left = deque(input().strip())
    right = deque()
    m = int(input())
    result = []

    for _ in range(m):
        line = input().split()
        com = line[0]

        if com == "L":
            if left:
                right.appendleft(left.pop())

        if com == "D":
            if right:
                left.append(right.popleft())

        if com == "B":
            if left:
                left.pop()

        if com == "P":
            s = line[1]
            left.append(s)

    result = ''.join(left+right)
    print(result)

if __name__ == "__main__":
    main()