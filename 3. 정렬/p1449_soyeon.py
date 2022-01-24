import sys

n, l = map(int, sys.stdin.readline().rstrip().split())
water = list(map(int, sys.stdin.readline().rstrip().split()))
water.sort()
t_start = water[0]
t_end = water[0] + l
count = 1
for i in water:
  if i < t_end:
    continue
  else:
    t_start = i
    t_end = i + l
    count += 1
print(count)
