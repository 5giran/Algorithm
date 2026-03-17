from collections import deque

import sys
input = sys.stdin.readline

def main():
    n = int(input())
    stack = deque()
    for _ in range(n):
        line = input().split()
        com = line[0]

        if com == "push":
            i = int(line[1])
            stack.append(i)

        elif com == "pop":
            if stack:
                print(stack.pop())
            else:
                print(-1)

        elif com == "size":
            print(len(stack))

        elif com == "empty":
            if stack:
                print(0)
            else:
                print(1)

        elif com == "top":
            if stack:
                print(stack[-1])
            else:
                print(-1)

if __name__ == "__main__":
    main()