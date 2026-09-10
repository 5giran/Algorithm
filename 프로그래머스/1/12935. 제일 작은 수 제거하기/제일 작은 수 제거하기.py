def solution(arr):
    answer = []
    n = float('inf') # 양의 무한대로 초기화
    
    for x in arr:
        answer.append(x)
        if x < n:
            n = x
            
    if len(arr) == 1:
        answer.pop(0)
        answer.append(-1)
    else:
        answer.remove(n)
        
    return answer