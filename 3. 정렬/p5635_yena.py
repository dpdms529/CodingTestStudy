#생일

import sys

n = int(sys.stdin.readline())
human = []
for i in range(n):
    name, day, month, year = sys.stdin.readline().split()
    human.append([name, int(day), int(month), int(year)])

human = sorted(human, key=lambda x: (x[3], x[2], x[1]))

print(human[-1][0])
print(human[0][0])
