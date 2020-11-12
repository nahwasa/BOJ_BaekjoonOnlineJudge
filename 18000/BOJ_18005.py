import sys
input = sys.stdin.readline
n = int(input())
if n&1 != 0:
    res = "0"
elif (n//2)&1 == 0:
    res = "2"
else:
    res = "1"
print(res)
