import sys, heapq

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())

computers = [[] for _ in range(n)]
vi = [False for _ in range(n)]
for _ in range(m):
    a, b, c = map(int, sys.stdin.readline().strip().split())
    computers[a-1].append([c, b-1])  # dist, dest
    computers[b-1].append([c, a-1])

que, total = [], 0
heapq.heappush(que, (0, 0))

while que:
    (dist, dest) = heapq.heappop(que)
    if not vi[dest]:
        vi[dest] = True
        total += dist
        for com in computers[dest]:
            heapq.heappush(que, (com[0], com[1]))

print(total)
