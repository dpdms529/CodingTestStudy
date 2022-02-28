# 문제집 - 위상 정렬, 우선 순위 큐
import sys
import heapq

# 입력
n, m = map(int, sys.stdin.readline().split())  # 문제 수, 정보 수
graph = [[] for _ in range(n+1)]
indegree = [0] * (n+1)  # indegree: 들어오는 화살표 수
for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)  # a -> b
    indegree[b] += 1


def topology_sort():
    result = []  # 수행 결과 저장 리스트
    q = []  # deque가 아닌 우선 순위 큐 사용 (원소가 작은 거부터 꺼내야 함)
    # indegree가 0이면 큐에 삽입
    for i in range(1, n+1):
        if indegree[i] == 0:
            heapq.heappush(q, i)
    while q:
        now = heapq.heappop(q)
        result.append(now)
        for i in graph[now]:
            indegree[i] -= 1
            if indegree[i] == 0:
                heapq.heappush(q, i)

    for i in result:
        print(i, end=' ')

topology_sort()
