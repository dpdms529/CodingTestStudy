# 파닭파닭

import sys

s, c = map(int, sys.stdin.readline().split())
l = [int(sys.stdin.readline()) for _ in range(s)]

start = 1
end = max(l)
while start <= end:
    mid = (start + end) // 2
    count = 0
    # rest = 0
    for x in l:
        count += x // mid
        # rest += x % mid
    if count >= c:
        start = mid + 1
        result = mid
        # result = rest
    else:
        end = mid - 1

# while문 안에서 나머지를 구할 경우 '1 3 \n 4'인 예제에서 나머지가 0으로 오답
print(sum(l) - result*c)
# print(result)
