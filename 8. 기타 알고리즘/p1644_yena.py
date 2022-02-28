# 소수의 연속합 (에라토스테네스의 체, 투 포인터)
import math
import sys

n = int(sys.stdin.readline())
array = [True for _ in range(n+1)]
data = []

for i in range(2, int(math.sqrt(n))+1):
    if array[i]:
        j = 2
        while i * j <= n:
            array[i*j] = False
            j += 1

for i in range(2, n+1):
    if array[i]:
        data.append(i)

count = 0
interval_sum = 0
end = 0

for start in range(len(data)):
    while interval_sum < n and end < len(data):
        interval_sum += data[end]
        end += 1
    if interval_sum == n:
        count += 1
    interval_sum -= data[start]

print(count)
