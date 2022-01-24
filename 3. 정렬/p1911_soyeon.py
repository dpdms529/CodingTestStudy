import sys

n, l = map(int, sys.stdin.readline().rstrip().split())
water = []
for _ in range(n):
  water.append(list(map(int, sys.stdin.readline().rstrip().split())))
water.sort(key=lambda water: water[0])

b_start = water[0][0]
b_end = b_start + l
count = 1
for i in water:
  if i[0] < b_end:
    while i[1] > b_end:
      count += 1
      b_end += l
    continue
  else:
    b_start = i[0]
    b_end = b_start + l
    count += 1
  while i[1] > b_end:
    count += 1
    b_end += l
print(count)
