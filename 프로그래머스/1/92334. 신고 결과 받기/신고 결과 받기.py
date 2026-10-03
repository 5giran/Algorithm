def solution(id_list, report, k):
    mail = {}
    reports = {}
    
    for x in id_list:
        mail[x] = 0     # value에 최종 리턴할 수 저장
        reports[x] = [] # value에 유저 신고한놈 저장
        
    for i in report:
        x, y = i.split()
        if x not in reports[y]:
            reports[y].append(x)
            
    for x in reports:
        if len(reports[x]) >= k:
            for y in reports[x]:
                mail[y] += 1
                
    answer = list(mail.values())
            
    
    return answer