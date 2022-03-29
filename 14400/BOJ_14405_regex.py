import re

regex = re.compile('(pi|ka|chu)*')
str = input()

if re.fullmatch(regex, str) :
    print("YES")
else:
    print("NO")
