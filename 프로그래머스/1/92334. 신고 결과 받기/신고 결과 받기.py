def solution(id_list, report, k):
    mail = {}
    reporters = {}

    for user in id_list:
        mail[user] = 0
        reporters[user] = set()

    for item in report:
        reporter, reported = item.split()
        reporters[reported].add(reporter)

    for reported in reporters:
        if len(reporters[reported]) >= k:
            for reporter in reporters[reported]:
                mail[reporter] += 1

    return list(mail.values())