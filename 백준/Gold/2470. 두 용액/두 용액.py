import sys
input = sys.stdin.readline

def main():
    n = int(input())
    num_list = list(map(int, input().split()))
    num_list.sort()

    result = [0, 0]
    left = 0
    right = n - 1
    min = float("inf")

    while left < right:
        sum = num_list[left] + num_list[right]

        if abs(sum) < min:
            min = abs(sum)
            result = [num_list[left], num_list[right]]

        if sum < 0:
            left += 1
        elif sum > 0:
            right -= 1
        else:
            break

    print(result[0], result[1])

if __name__ == "__main__":
    main()