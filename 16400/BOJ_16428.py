import sys
input = sys.stdin.readline
a,b = map(int, input().split())
flag = False
if b < 0 :
    flag = True
    b = -b
cal = divmod(a,b)
print(flag and -cal[0] or cal[0])
print(cal[1])
