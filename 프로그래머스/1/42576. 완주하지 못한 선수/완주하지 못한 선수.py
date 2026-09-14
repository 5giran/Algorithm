def solution(participant, completion):
    answer = ''
    a = {}
    
    for x in completion:
        if x in a:
            a[x] += 1
        else:
            a[x] = 1
        
    for x in participant:
        if x not in a:
            answer += x
        else:
            a[x] -= 1
            
    for k, v in a.items():
        if v  == -1:
            answer += k
            
    return answer