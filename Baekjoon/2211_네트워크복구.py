import heapq
import sys

N, M = map(int, sys.stdin.readline().strip().split())
arr = [[] for _ in range(N)]
vi = [sys.maxsize for _ in range(N)]

for _ in range(M):
    a, b, c = map(int, sys.stdin.readline().strip().split())
    arr[a - 1].append([b - 1, c])
    arr[b - 1].append([a - 1, c])  # 쌍방향으로 등록

# dijkstra
que, res = [], []
heapq.heappush(que, [0, 0, 0])
vi[0] = 0

while que:
    tmp = heapq.heappop(que)
    dist, sta, end = tmp[0], tmp[1], tmp[2]

    if dist != 0 and dist < vi[end]:
        vi[end] = dist
        res.append([sta + 1, end + 1])
    elif dist != 0:
        continue  # 최소경로를 모두 찾고 que에 남아있는 회선들

    for nend, dist2 in arr[end]:
        if vi[end] + dist2 < vi[nend]:
            heapq.heappush(que, [vi[end] + dist2, end, nend])

print(len(res))
for r in res:
    print(f'{r[0]} {r[1]}')
