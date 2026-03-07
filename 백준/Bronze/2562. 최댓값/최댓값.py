import sys
input = sys.stdin.readline

n_list = [int(input()) for _ in range(9)]

max_n = 0
max_i = 0
count = 1

for i in n_list:
    if i > max_n:
        max_n = i
        max_i = count
    count += 1

print(max_n)
print(max_i)