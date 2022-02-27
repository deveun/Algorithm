import sys

sys.setrecursionlimit(10 ** 5 + 1)


def dfs(root):
    for a in arr[root]:
        if not vi[a]:
            vi[a] = True
            dfs(a)
            parent[a] = root


### MAIN
n = int(sys.stdin.readline().strip())

arr = [[] for _ in range(n + 1)]

for _ in range(n - 1):
    node1, node2 = map(int, sys.stdin.readline().strip().split())
    arr[node1].append(node2)
    arr[node2].append(node1)

# print(arr)

parent = [-1 for _ in range(n + 1)]
vi = [False for _ in range(n + 1)]
dfs(1)

# print(parent)
for r in range(2, len(parent)):
    print(parent[r])
