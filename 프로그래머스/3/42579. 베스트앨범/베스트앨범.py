def solution(genres, plays):
    answer = []
    
    totals = {}
    best = {}
    
    for i in range(len(genres)):
        g = genres[i]
        p = plays[i]
        
        if g not in totals:
            totals[g] = 0
            best[g] = []
            
        totals[g] += p
        
        best[g].append((i, p))
        best[g].sort(key=lambda song: (-song[1], song[0]))
        best[g] = best[g][:2]
        
        g_sort = sorted(
            totals,
            key=lambda g: totals[g],
            reverse=True
        )
        
    for g in g_sort:
        for song in best[g]:
            answer.append(song[0])
        
    
    return answer