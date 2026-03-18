import sys
input = sys.stdin.readline

def main():
    MAX = 1_000_001
    nxt = [0] * MAX
    prv = [0] * MAX

    N, M = map(int, input().split())
    stations = list(map(int, input().split()))

    for idx in range(N):
        cur = stations[idx]
        nxt_s = stations[(idx + 1) % N]
        prv_s = stations[(idx - 1) % N]
        nxt[cur] = nxt_s
        prv[cur] = prv_s

    out = []

    for _ in range(M):
        line = input().split()
        op = line[0]

        if op == "BN":
            i, j = int(line[1]), int(line[2])
            out.append(nxt[i])
            old_next = nxt[i]
            nxt[i] = j
            prv[j] = i
            nxt[j] = old_next
            prv[old_next] = j

        elif op == "BP":
            i, j = int(line[1]), int(line[2])
            out.append(prv[i])
            old_prev = prv[i]
            prv[i] = j
            nxt[j] = i
            prv[j] = old_prev
            nxt[old_prev] = j

        elif op == "CN":
            i = int(line[1])
            target = nxt[i]
            out.append(target)
            new_next = nxt[target]
            nxt[i] = new_next
            prv[new_next] = i

        elif op == "CP":
            i = int(line[1])
            target = prv[i]
            out.append(target)
            new_prev = prv[target]
            prv[i] = new_prev
            nxt[new_prev] = i

    sys.stdout.write("\n".join(map(str, out)) + "\n")

main()