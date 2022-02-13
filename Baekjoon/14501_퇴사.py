import sys

def dfs(day, price):
    nextDay = day + days[day][0] - 1
    if nextDay < n and total[nextDay] < price + days[day][1]:
        total[nextDay] = price + days[day][1]
        for next in range(nextDay+1, n):
            dfs(next, total[nextDay])


n = int(sys.stdin.readline())

total = [0 for _ in range(n)]
days = list()
for _ in range(n):
    t, p = map(int, sys.stdin.readline().strip().split())
    days.append((t, p))

for day in range(n):
    dfs(day, 0)

print(max(total))
