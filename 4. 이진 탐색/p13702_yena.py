# 이상한 술집

import sys

n, k = map(int, sys.stdin.readline().split())
array = []
for i in range(n):
    array.append(int(sys.stdin.readline()))

start = 1   # 0으로 설정하면 틀림
end = max(array)
while start <= end:
    mid = (start + end) // 2
    count = 0
    for i in array:
        count += i // mid
    if count >= k:
        result = mid
        start = mid + 1
    else:
        end = mid - 1

print(result)
