import sys

def chkOut(i, j):

    que, vi = [(i, j)], [[False for _ in range(c)] for _ in range(r)]
    noCheese = set()
    isOut = False

    while que:
        ii, jj = que.pop()
        noCheese.add((ii, jj))
        for dir in range(4):
            ni, nj = ii + di[dir], jj + dj[dir]
            if ni < 0 or nj < 0 or ni >= r or nj >= c or arr[ni][nj] == 'X':
                # 외부랑 접촉되어있음!
                isOut = True

            elif not vi[ni][nj] and arr[ni][nj] == '0':
                # 아직 해당 치즈 없는 부분이 외부랑 접촉되어있는지 모르는 경우
                # que에 추기하고 다시 BFS 탐색을 해볼 수 있도록
                que.append((ni, nj))
                vi[ni][nj] = True

    # 외부와 접촉된 칸이 하나라도 있다면
    # que에 저장되어 있는 칸은 모두 -1로 값 바꾸고 끝내기
    if isOut:
        # for i, j in que:
        for i, j in noCheese:
            arr[i][j] = 'X'

def removeCheese(cheese):

    # 2_1. 치즈의 사방탐색에서 'X'가 2개 이상일 때 해당 치즈 녹이기
    #       & 녹인 위치는 'X'이고, 주변에 BFS로 '0'을 찾아 바꿔주기
    delQue = list()
    vi = [[False for _ in range(c)] for _ in range(r)]
    for i, j in cheese:
        cnt = 0
        for dir in range(4):
            ni, nj = i + di[dir], j + dj[dir]
            if arr[ni][nj] == 'X':
                cnt += 1

        if cnt >= 2:
            delQue.append((i, j))
            vi[i][j] = True

    for ii, jj in delQue:
        cheese.remove((ii, jj))

    while delQue:
        ii, jj = delQue.pop()
        arr[ii][jj] = 'X'
        for dir in range(4):
            ni, nj = ii + di[dir], jj + dj[dir]
            if ni >= 0 and nj >= 0 and ni < r and nj < c and not vi[ni][nj] and arr[ni][nj] == '0':
                delQue.append((ni, nj))
                vi[ni][nj] = True


### MAIN
di, dj = [0, 1, 0, -1], [1, 0, -1, 0]

r, c = map(int, sys.stdin.readline().strip().split())

arr = list()
for _ in range(r):
    arr.append(sys.stdin.readline().strip().split())


# BFS
# 격자 밖에 도달했다면 공기와 접촉한것으로 생각한다.

# 1. 치즈가 아닐 때, 공기와 접한 곳인지 판단
#   & BFS를 진행할 치즈의 위치를 que에 저장
cheese = list()
for i in range(r):
    for j in range(c):
        if arr[i][j] == '0':
            chkOut(i, j)
        elif arr[i][j] == '1':
            cheese.append((i, j))

# 2. 치즈인 경우 치즈 녹이기 & 없어질 때까지 반복
time = 0
while cheese:
    # print(cheese)
    # print(arr)
    removeCheese(cheese)
    time+=1

print(time)









