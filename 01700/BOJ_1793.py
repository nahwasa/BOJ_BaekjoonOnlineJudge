import sys
input = sys.stdin.readline

def initDpArray():
    global dp
    dp = [0 for i in range(n+3)]
    dp[0] = 1
    dp[1] = 1
    dp[2] = 3

while 1:
    try:
        n = int(input())
        initDpArray()

        for i in range(3, n+1):
            dp[i] = 2*dp[i-2] + dp[i-1]
        print(dp[n])

    except:
        break
