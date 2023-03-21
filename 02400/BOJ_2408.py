n = int(input())

tmp = ""
for _ in range(n*2-1):
    tmp += str(input())
tmp = tmp.replace('/', '//')
print(eval(tmp))
