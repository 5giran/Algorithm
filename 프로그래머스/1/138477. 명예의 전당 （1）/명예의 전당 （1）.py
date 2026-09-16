def solution(k, score):
    answer = []
    m = []
    
    for x in score:
        if not m or len(m) < k:
            m.append(x)
            m.sort(reverse=True)
        else:
            if m[-1] < x:
                m.pop(-1)
                m.append(x)
                m.sort(reverse=True)
        answer.append(m[-1])
        m.sort(reverse=True)
            
                
    
    return answer