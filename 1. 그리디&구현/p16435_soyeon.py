n, l = map(int, input().split())
h_list = list(map(int, input().split()))
h_list.sort()
for h in h_list:
  if h <= l:
    l += 1
print(l)
