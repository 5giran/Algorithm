import sys
input = sys.stdin.readline

def main():
    N = int(input())
    matrix = [list(map(int, input().split())) for _ in range(N)]
    result = [0, 0]

    def check(x, y, size):
        base = matrix[x][y]
        for i in range(x, x+size):
            for j in range(y, y+size):
                if matrix[i][j] != base:
                    return None
        return base
    
    def divide(x, y, size):
        val = check(x, y, size)
        if val is not None:
            result[val] += 1
            return
        
        half = size // 2
        divide(x, y, half)
        divide(x+half, y, half)
        divide(x, y+half, half)
        divide(x+half, y+half, half)

    divide(0, 0, N)
    print(result[0])
    print(result[1])

if __name__ == "__main__":
    main()