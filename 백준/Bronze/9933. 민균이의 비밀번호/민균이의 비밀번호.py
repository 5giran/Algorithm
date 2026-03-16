import sys
input = sys.stdin.readline

def main():
    N = int(input())
    file_word = [input().strip() for _ in range(N)]

    for word in file_word:
        re_word = word[::-1]
        for i in file_word:
            if re_word == i:
                len_pw = len(i)
                mid = len_pw // 2
                mid_spell = i[mid]
                print(f"{len_pw} {mid_spell}")
                return

if __name__ == "__main__":
    main()