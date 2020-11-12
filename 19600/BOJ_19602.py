import sys


def get_input():
    return int(sys.stdin.readline())


input_ = get_input
print(input_() + 2 * input_() + 3 * input_() >= 10 and 'happy' or 'sad')
