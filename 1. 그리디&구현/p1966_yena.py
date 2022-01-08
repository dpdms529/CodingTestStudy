# 프린터 큐

import sys

case = int(sys.stdin.readline())
for i in range(case):
    index = []
    n, m = map(int, sys.stdin.readline().split())
    rank = list(map(int, sys.stdin.readline().split()))
    for j in range(n):
        index.append(j)

    # 출력 처리
    count = 0
    M = m
    # 자신보다 큰 값이 있을 때
    while rank[m] < max(rank):
        del_rank = rank.pop(0)
        rank.append(del_rank)
        del_index = index.pop(0)
        index.append(del_index)
        if del_rank == max(rank):
            count += 1
            rank.pop()
            index.pop()
        # else:
        #     rank.append(del_rank)
        #     index.append(del_index)
        m = index.index(M)

    # 자신이 최대값일 때
    while rank[m] == max(rank):
        del_rank = rank.pop(0)
        rank.append(del_rank)
        del_index = index.pop(0)
        index.append(del_index)
        if del_rank == max(rank) and del_index == M:
            count += 1
            break
        elif del_rank == max(rank) and del_index != M:
            count += 1
        m = index.index(M)

    print(count)
