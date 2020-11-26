import sys
input = sys.stdin.readline

tc = int(input())
arr = [0] * tc
for i in range(0, tc):
    arr[i] = int(input())
max = max(arr)
max = max>0 and max or 1
dp = [[0 for _ in range(max+1)] for _ in range(2)]
dp[0][0] = 1
dp[1][1] = 1

for i in range(2, max+1):
    dp[0][i] = dp[0][i - 1] + dp[0][i - 2]
    dp[1][i] = dp[1][i - 1] + dp[1][i - 2]

for i in arr:
    print(dp[0][i], end=" ")
    print(dp[1][i])
