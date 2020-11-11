import sys
input = sys.stdin.readline
a = int(input())
b = int(input())
print(divmod((a+b), 2)[0], end="\n")
print(divmod((a-b), 2)[0])
"""
print((a+b)//2, end="\n")
print((a-b)//2)
"""
