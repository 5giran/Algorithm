def solution(arr):
    
    if len(arr) == 1:
        return [-1]
    
    n = min(arr)
    arr.remove(n)
    
    return arr