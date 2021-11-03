import sys

tc = int(sys.stdin.readline())
for _ in range(tc):
    N, M, W = map(int, sys.stdin.readline().strip().split()) # 정점개수, 도로개수, 웜홀개수
    arr = [[] for _ in range(N)]
    res = 'NO'

    # 도로
    for _ in range(M):
        s, e, t = map(int, sys.stdin.readline().strip().split()) # 연결지점, 이동거리
        arr[s-1].append((e-1, t))
        arr[e-1].append((s-1, t))
    
    # 웜홀
    for _ in range(W):
        s, e, t = map(int, sys.stdin.readline().strip().split())
        arr[s-1].append((e-1, t * -1))

    # 최단거리 배열
    dist = [ sys.maxsize for _ in range(N)]
    dist[0] = 0

    # 벨만포드 - (모든 간선 개수) X (정점개수-1)
    for _ in range(N-1):
        for n in range(N):
            for ee, tt in arr[n]:
                if dist[ee] > dist[n] + tt:
                    dist[ee] = dist[n] + tt


    # 벨만포드 - 음의 사이클 확인
    for n in range(N):
        for ee, tt in arr[n]:
            if dist[ee] > dist[n] + tt:
                # dist[ee] = dist[n] + tt
                res = "YES"

    print(res)