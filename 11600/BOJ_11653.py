import sys
input = sys.stdin.readline

n = int(input())
for i in range(2, n+1):
    while n%i == 0:
        print(i)
        n//=i
    if n==1:
        break
