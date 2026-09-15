def solution(nums):
    answer = 0
    dic = {}
    
    for x in nums:
        dic[x] = 1
        
        
    if len(nums) // 2 < len(dic):
        answer = len(nums) // 2
    else:
        answer = len(dic)
    
    return answer