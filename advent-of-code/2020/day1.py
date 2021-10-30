def find_sum(lines):
    lines.sort()
    for i in lines:
        for j in reversed(lines):
            if i + j == 2020:
                return i*j

with open('input.txt') as f:
    lines = [int(x) for x in f.read().strip().split('\n')]

print(find_sum(lines))
