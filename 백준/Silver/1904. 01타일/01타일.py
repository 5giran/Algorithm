import sys
input = sys.stdin.readline

def main():
    n = int(input())
    if n == 1:
        print(1)
        return
    dp = [0] * (n+1)
    dp[1] = 1
    dp[2] = 2 % 15746
    for i  in range(3, n+1):
        dp[i] = (dp[i-1] + dp[i-2]) % 15746

    print(dp[n])

if __name__ == "__main__":
    main()
