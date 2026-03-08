import sys
input = sys.stdin.readline

n = int(input())
n_list = list(map(int, input().split()))
prime_cnt = 0

for i in range(n):
    d_list = list()
    d_num = n_list[i]
    for x in range(1, d_num + 1):
        if d_num % x == 0:
            d_list.append(x)
    if len(d_list) == 2:
        prime_cnt += 1

print(prime_cnt)