import sys
input = sys.stdin.readline
n,w,h,l = map(int, input().split())
cal = (h//l) * (w//l)
print(min(n,cal))
