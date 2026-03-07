import sys
input = sys.stdin.readline

c = int(input())
p_list = list()

for _ in range(c):
    s_list = list(map(int, input().split()))
    s_count = s_list[0]
    ab = 0

    s_sum = sum(s_list[1:])
    s_ave = s_sum/s_count

    for s in s_list[1:]:
        if s_ave < s:
            ab += 1

    p_list.append(f"{round(ab/s_count*100, 3):.3f}%")

for p in p_list:
    print(p)