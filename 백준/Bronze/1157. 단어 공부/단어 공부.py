import sys
input = sys.stdin.readline

word = input().upper().strip()
d = {}

for w in word:
    if w not in d:
        d[w] = 0
    if w in d:
        d[w] += 1

max_value = max(d.values())

max = [k for k, v in d.items() if max_value == v]

if len(max) == 1:
    print(max[0])
else:
    print("?")
