import sys
iput = sys.stdin.readline


n = int(input())
n_list = list(map(int, input().split()))
s_n_list = sorted(n_list)
m = int(input())
m_list = list(map(int, input().split()))


for t in m_list:
    left = 0
    right = (len(s_n_list)) - 1
    check = 0
    while left <= right:
        mid = (left + right) // 2
        if s_n_list[mid] == t:
            print(1)
            check += 1
            break
        elif s_n_list[mid] < t:
            left = mid + 1
        else:
            right = mid - 1
    if check == 0:
        print(0)