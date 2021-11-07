import heapq
import sys


def dijkstra():
    global vi

    que = []
    vi[0][0] = arr[0][0]
    heapq.heappush(que, (vi[0][0], 0, 0))  # 출발지

    while que:
        tmp = heapq.heappop(que)

        if tmp[1] == N - 1 and tmp[2] == N - 1:
            return vi[N - 1][N - 1]

        for n in range(4):
            ni, nj = tmp[1] + di[n], tmp[2] + dj[n]
            if 0 <= ni < N and 0 <= nj < N and vi[ni][nj] > arr[ni][nj] + tmp[0]:
                vi[ni][nj] = arr[ni][nj] + tmp[0]
                heapq.heappush(que, (vi[ni][nj], ni, nj))


# MAIN
di, dj = [1, 0, -1, 0], [0, 1, 0, -1]

for i in range(1, sys.maxsize):
    N = int(sys.stdin.readline())

    if N == 0:
        exit()

    arr = [list(map(int, sys.stdin.readline().strip().split())) for _ in range(N)]
    vi = [[sys.maxsize for _ in range(N)] for _ in range(N)]  # 0,0 -> i,j까지의 최단 거리를 저장하는 배열
    print(f'Problem {i}: {dijkstra()}')
