def solution(arr):
    answer = []
    
    for x in arr:
        if not answer:
            answer.append(x)
        if answer[-1] == x:
            continue
        else:
            answer.append(x)
    
    return answer