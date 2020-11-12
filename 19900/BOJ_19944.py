import sys
input = sys.stdin.readline
a,b = map(int, input().split())
if b <= 2 :
    res = "NEWBIE!"
elif b <= a :
    res = "OLDBIE!"
else :
    res = "TLE!"
print(res)
