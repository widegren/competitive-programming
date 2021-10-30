def find_sum_2020(lines):
    lines.sort()
    for i in lines:
        for j in reversed(lines):
            if i + j == 2020:
                return i*j

with open('input.txt') as f:
    lines = [int(x) for x in f.read().strip().split('\n')]

print(find_sum_2020(lines))

lines.sort()
for i, val in enumerate(lines):
    for j in lines[i:]:
        for k in reversed(lines):
            if val + j + k == 2020:
                print(val*j*k)
