import sys
input = sys.stdin.readline

ori = input()
ori = ori.strip()
if ori.find("()") != -1:
	print("ROCK")
	quit()
		
# for c in ori:
# 	if c not in ['+', '-', '/', '*', '(', ')', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0']:
# 		print("ROCK")
# 		quit()

rep = '&'
chk = ori.replace('/', rep).replace('-', rep).replace('+', rep).replace('*', rep)

try:
	eval(chk)
except:
	print("ROCK")
	quit()
	
try:
	print(eval(ori.replace('/', "//")))
except:
	print("ROCK")
