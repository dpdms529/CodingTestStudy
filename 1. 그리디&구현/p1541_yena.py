# 잃어버린 괄호

s = input()
s += 'E'
result = 0
str_num = ''
tmp_num = 0
open = False

for i in s:
    if i.isdigit():
        str_num += i
    else:
        if open:
            tmp_num += int(str_num)
        else:
            result += int(str_num)
        if i == '-' and open == False:
            open = True
        elif i == '-' and open == True:
            result -= tmp_num
            tmp_num = 0
        str_num = ''
        if i == 'E':
            result -= tmp_num

print(result)