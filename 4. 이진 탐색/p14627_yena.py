# 파닭파닭

import sys

# 입력
s, c = map(int, sys.stdin.readline().split())
l = [int(sys.stdin.readline()) for _ in range(s)]

# 과정
start = 1   # 1부터 시작
end = max(l)    # 최대값을 end로 설정
while start <= end:
    mid = (start + end) // 2
    count = 0
    # rest = 0
    for x in l:
        count += x // mid
        # rest += x % mid
    if count >= c:  # 나눠줘야 할 양보다 크거나 같으면 결과값 저장
        start = mid + 1
        result = mid
        # result = rest
    else:
        end = mid - 1

# while문 안에서 나머지를 구할 경우 '1 3 \n 4'인 예제에서 나머지가 0으로 오답
print(sum(l) - result*c)
# print(result)
