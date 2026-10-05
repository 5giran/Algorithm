def solution(clothes):
    category = {}
    answer = 1
    
    for k in range(len(clothes)):
        if clothes[k][1] not in category:
            category[clothes[k][1]] = []
        category[clothes[k][1]].append(clothes[k][0])

    for i in category:
        answer *= len(category[i]) + 1
        
    return answer - 1
            
    