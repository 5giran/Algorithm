import sys
input = sys.stdin.readline

def main():
    n = int(input())
    def fib(n, memo=None):
        if memo is None:
            memo = {}
        if n in memo:
            return memo[n]
        if n == 0:
            return 0
        elif n == 1:
            return 1
        else:
            memo[n] = fib(n-1, memo) + fib(n-2, memo)

        return memo[n]
    
    print(fib(n))
    
if __name__ == "__main__":
    main()