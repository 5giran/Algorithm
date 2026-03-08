import sys
input = sys.stdin.readline

t = int(input())
r_list = list()

for _ in range(t):
    text = list(input().strip())
    count = int(text[0])
    repeat = list()
    for re in text[2:]:
        repeat.append(re*count)
    
    r_list.append(''.join(repeat))

for r in r_list:
    print(r)
