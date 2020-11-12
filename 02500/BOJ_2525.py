import sys
from datetime import datetime, timedelta
input = sys.stdin.readline
h,m = map(int, input().split())
t = datetime.now()
t = t.replace(hour=h,minute=m)
t += timedelta(minutes=int(input()))
print(t.hour, end=" ")
print(t.minute)
