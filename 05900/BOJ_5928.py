import sys
input = sys.stdin.readline
a,b,c = map(int, input().split())
calc = a*1440 + b*60 + c - (11*1440 + 11*60 + 11)
print( calc<0 and -1 or calc )
