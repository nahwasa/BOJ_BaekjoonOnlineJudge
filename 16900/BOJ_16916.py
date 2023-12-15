import sys
input = sys.stdin.readline

s = input().rstrip()
p = input().rstrip()
if s.__contains__(p):
    print(1)
else:
    print(0)
