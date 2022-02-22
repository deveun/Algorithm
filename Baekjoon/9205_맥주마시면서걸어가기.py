import sys, math

def dfs(sta, end):
    global res

    if res != 'sad' or arr[sta][end]:
        res = 'happy'
        return

    for r in range(n+2):
        if not vi[r] and arr[sta][r]:
            vi[r] = True
            dfs(r, end)
            # vi[r] = False

### MAIN
tc = int(sys.stdin.readline().strip())

for _ in range(tc):

    # number of store
    n = int(sys.stdin.readline().strip())

    # stores = start + stores + destination
    stores = [() for _ in range(n+2)]

    # start
    staX, staY = map(int, sys.stdin.readline().strip().split())
    stores[0] = (staX, staY)

    # store
    for r in range(1, n+1):
        stoX, stoY = map(int, sys.stdin.readline().strip().split())
        stores[r] = (stoX, stoY)

    # destination
    endX, endY = map(int, sys.stdin.readline().strip().split())
    stores[n+1] = (endX, endY)

    # result - sad / happy
    res = 'sad'

    # 인접배열, visit 배열
    arr = [[False for _ in range(n+2)] for _ in range(n+2)]
    vi = [False for _ in range(n+2)]
    for i in range(n+2):
        for j in range(n+2):
            s1, s2 = stores[i], stores[j]

            dist = abs(s1[0]-s2[0]) + abs(s1[1]-s2[1])
            beer = math.ceil(dist/50)

            if beer <= 20 and i != j:
                arr[i][j] = True  # store i,j 이동 가능 여부
                arr[j][i] = True

    vi[0] = True
    dfs(0, n+1)
    print(res)

