import sys

N = int(sys.stdin.readline())
num = list(map(int, sys.stdin.readline().strip().split()))

p = [ 0 for _ in range(N)]
p[0] = num[0]

for r in range(1,N):
    p[r] = max(p[r-1]+num[r], num[r])

print(sorted(p)[N-1])
