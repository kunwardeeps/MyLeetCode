import heapq

def kClosest(points, K):
    pq = []
    for p in points:
        dist = p[0] * p[0] + p[1] * p[1]
        heapq.heappush(pq, (-dist, p))
        if len(pq) > K:
            heapq.heappop(pq)
    res = []
    while K > 0:
        res.append(heapq.heappop(pq)[1])
        K -= 1
    return res

print(kClosest([[1, 3], [-2, 2]], 1) == [[-2, 2]])
print(kClosest([[3, 3], [5, -5], [-2, 4]], 2) == [[3, 3], [-2, 4]])