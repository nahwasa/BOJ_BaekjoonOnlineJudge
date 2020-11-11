import sys
input = sys.stdin.readline
n = int(input())
num = -1
str = ""
for i in range (0,n) :
    arr = input().split(" ")
    a = arr[0]
    b = int(arr[1])
    if num == b and str > a :
        str = a
    elif num < b :
        num = b
        str = a
print(str)
