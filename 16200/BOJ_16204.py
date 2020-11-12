import sys
input = sys.stdin.readline
n,m,k = map(int, input().split())
print(min(m, k) + min(n-m, n-k))
