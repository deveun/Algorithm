import sys

def dfs(man1, man2, cnt):
    global res

    if res != -1:
        return

    for r in range(n):
        if not vi[man1][r] and arr[man1][r]:
            if r == man2:
                res = cnt
            else:
                vi[man1][r], vi[r][man1] = True, True
                dfs(r, man2, cnt+1)
                vi[man1][r], vi[r][man1] = False, False

### MAIN
n = int(sys.stdin.readline())
man1, man2 = map(lambda x: int(x)-1, sys.stdin.readline().strip().split())
m = int(sys.stdin.readline())

arr = [[False for _ in range(n)] for _ in range(n)]
vi = [[False for _ in range(n)] for _ in range(n)]
res = -1

for _ in range(m):
    p, c = map(lambda x: int(x)-1, sys.stdin.readline().strip().split())
    arr[p][c], arr[c][p] = True, True

dfs(man1, man2, 1)
print(res)

