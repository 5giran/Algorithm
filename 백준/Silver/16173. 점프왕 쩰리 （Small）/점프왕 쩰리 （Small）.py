import sys
input = sys.stdin.readline

def main():
    N = int(input())
    board = [list(map(int, input().split())) for _ in range(N)]

    def dfs(row, col):
        # base case
        if row < 0 or row >= N or col < 0 or col >= N:
            return "Hing"
        elif board[row][col] == -1:
            return "HaruHaru"
        elif board[row][col] == 0:
            return "Hing"
        
        # recursive case
        k = board[row][col]
        if dfs(row + k, col) == "HaruHaru" or dfs(row, col + k) == "HaruHaru":
            return "HaruHaru"
        else:
            return "Hing"
        
    print(dfs(0, 0))
        
if __name__ == "__main__":
    main()