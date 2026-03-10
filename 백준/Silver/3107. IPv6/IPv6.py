import sys
input = sys.stdin.readline


ip = input().strip().split(":")


if "" in ip: 
    emp_idx = ip.index("")
    ip = [x for x in ip if x != ""]
    cnt = 8 - len(ip)
    ip[emp_idx:emp_idx] = ["0000"]*cnt

for i, v in enumerate(ip):
    if len(v) < 4:
        ip[i] = "0"*(4-len(v))+v

result = ":".join(ip)
print(result)
