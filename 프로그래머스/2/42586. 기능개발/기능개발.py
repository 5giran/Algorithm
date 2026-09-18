def solution(progresses, speeds):
    answer = []
    
    while progresses:
        for i in range(len(progresses)):
            progresses[i] += speeds[i]
        
        if progresses[0] >= 100:
            count = 0
            
            for x in progresses:
                if x >= 100:
                    count += 1
                else:
                    break
            
            answer.append(count)
            progresses = progresses[count:]
            speeds = speeds[count:]
    
    return answer