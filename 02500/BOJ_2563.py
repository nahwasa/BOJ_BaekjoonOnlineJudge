import sys
input=sys.stdin.readline

arr = [[0 for _ in range(100)] for _ in range(100)]
n = int(input())
ans = 0

for _ in range(n):
    r, c = map(int, input().split())
    for i in range(r, r+10):
        for j in range(c, c+10):
            arr[i][j] += 1
            if arr[i][j] == 1:
                ans += 1

print(ans)
