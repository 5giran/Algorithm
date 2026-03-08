from collections import Counter
import sys
input = sys.stdin.readline


word = input().upper().strip()

word_cnt = Counter(word)

max_cnt = max(word_cnt.values())
max_ap = [k for k, v in word_cnt.items() if max_cnt == v]

if len(max_ap) == 1:
    print(max_ap[0])
else:
    print("?")