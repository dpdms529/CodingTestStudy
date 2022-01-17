n = int(input())
meeting = []
for _ in range(n):
  meeting.append(list(map(int, input().split())))
sorted_meetings = sorted(meeting, key=lambda x: (x[1], x[0]))
avail = []
avail.append(sorted_meetings.pop(0))
for sorted_m in sorted_meetings:
  size = len(avail)
  if(sorted_m[0]>=avail[size-1][1]):
    avail.append(sorted_m)
print(len(avail))
