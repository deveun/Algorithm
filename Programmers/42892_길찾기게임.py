import sys
sys.setrecursionlimit(10**5)

def getSubTree(nodes):
    parent = nodes[0]
    leftNodes = list(filter(lambda x: x[1] < parent[1], nodes))
    rightNodes = list(filter(lambda x: x[1] > parent[1], nodes))

    left = getSubTree(leftNodes) if leftNodes else False
    right = getSubTree(rightNodes) if rightNodes else False
    return (left, right, parent[0])


# parent -> left -> right
def preOrder(tree, pre):

    pre.append(tree[2])

    preOrder(tree[0], pre) if tree[0] else None
    preOrder(tree[1], pre) if tree[1] else None

    return pre

# left -> right -> parent
def postOrder(tree, post):

    postOrder(tree[0], post) if tree[0] else None
    postOrder(tree[1], post) if tree[1] else None

    post.append(tree[2])

    return post


def solution(nodeinfo):
    # left, right sub tree를 recursive를 통해 구해줌

    nodes = [(idx+1, x, y) for idx, (x, y) in enumerate(nodeinfo)]
    nodes = sorted(nodes, key=lambda x: x[2] * -1)
    tree = getSubTree(nodes)  # (leftTree, rightTree)

    # print(nodes)

    pre, post = [], []
    pre = preOrder(tree, pre)
    post = postOrder(tree, post)

    # print([pre, post])
    return [pre, post]

solution([[5, 3], [11, 5], [13, 3], [3, 5], [6, 1], [1, 3], [8, 6], [7, 2], [2, 2]])
