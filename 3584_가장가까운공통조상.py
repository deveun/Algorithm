import sys

sys.setrecursionlimit(10**4)

def findParent(node, parentSet):
    global res

    # 최상위 node에 도달하였거나, 공통된 조상을 찾은 경우
    if node == 0 or res != -1:
        return

    if node in parentSet:
        res = node
        return

    parentSet.add(node)
    findParent(parents[node], parentSet)

### MAIN
tc = int(sys.stdin.readline().strip())
for _ in range(tc):

    n = int(sys.stdin.readline().strip())
    parents = [0 for _ in range(n + 1)]
    for _ in range(n-1):
        parent, child = map(int, sys.stdin.readline().split())
        parents[child] = parent

    # print(parents)
    node1, node2 = map(int, sys.stdin.readline().split())
    parentSet = set()
    res = -1

    findParent(node1, parentSet)
    findParent(node2, parentSet)

    print(res)
