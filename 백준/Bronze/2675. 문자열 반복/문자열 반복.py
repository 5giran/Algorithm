import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    re_cnt, text = input().split()
    r_list = [s*int(re_cnt) for s in text]
    
    print(''.join(r_list))