def solution(arr):
    
    if len(arr) == 1:
        return [-1]
    
    n = float('inf')
    
    for x in arr:
        if n > x:
            n = x
            
    arr.remove(n)
    
    return arr