import sys
input = sys.stdin.readline

n_list = [int(input()) for _ in range(9)]

max_n = max(n_list)
max_i = n_list.index(max_n) + 1

print(f"{max_n}\n{max_i}")