from queue import PriorityQueue

class Graph:
    def __init__(self, num_of_vertices):
        self.v = num_of_vertices
        self.edges = {}
        self.visited = []
    def add_edge(self, u, v, weight):
        temp_u = [] 
        temp_v = []
        if u not in self.edges:
            temp_u.append([v, weight])
            temp_v.append([u, weight])
            self.edges[u] = temp_u
            self.edges[v] = temp_v
        if v not in self.edges:
            temp_u.extend(self.edges[u])
            temp_u.append([v,weight])
            temp_v.append([u, weight])
            self.edges[u] = temp_u
            self.edges[v] = temp_v
        else:
            temp_u.extend(self.edges[u])
            temp_v.extend(self.edges[v])
            temp_u.append([v, weight])
            temp_v.append([u, weight])
            self.edges[u] = temp_u
            self.edges[v] = temp_v
        
def dijkstra(graph, start_vertex):
    D = {v:float('inf') for v in range(graph.v)}
    D[start_vertex] = 0
    #The Python priority queue is built on the heapq module, which is basically a binary heap.
    pq = PriorityQueue()
    pq.put((0, start_vertex))

    while not pq.empty():
        (dist, current_vertex) = pq.get()
        graph.visited.append(current_vertex)

        for neighbor in range(graph.v):
            for item in graph.edges[current_vertex]:
                vertex, distance = item
                if vertex == neighbor:
                    if neighbor not in graph.visited:
                        old_cost = D[neighbor]
                        new_cost = D[current_vertex] + distance
                        if new_cost < old_cost:
                            pq.put((new_cost, neighbor))
                            D[neighbor] = new_cost
    return D

g = Graph(9)
g.add_edge(0, 1, 4)
g.add_edge(0, 6, 7)
g.add_edge(1, 6, 11)
g.add_edge(1, 7, 20)
g.add_edge(1, 2, 9)
g.add_edge(2, 3, 6)
g.add_edge(2, 4, 2)
g.add_edge(3, 4, 10)
g.add_edge(3, 5, 5)
g.add_edge(4, 5, 15)
g.add_edge(4, 7, 1)
g.add_edge(4, 8, 5)
g.add_edge(5, 8, 12)
g.add_edge(6, 7, 1)
g.add_edge(7, 8, 3) 

D = dijkstra(g, 0)
print(D)
for vertex in range(len(D)):
    print("Distance from vertex 0 to vertex", vertex, "is", D[vertex])
   
# Time Complexity
# In this algorithm, we pass each edge once, which results in time complexity of O(|E|), where |E| represents the number of edges.
# We also visit each node once, which results in time complexity of O(|V|), where |V| represents the number of vertices. Each vertex will be put in a priority queue, where finding the next closest vertex is going to be done in constant O(1) time. However, we use O(Vlog|V|) time to sort the vertices in this priority queue.
# This results in time complexity of this algorithm being O(|E|+|V|log|V|)

# Source:
# https://stackabuse.com/courses/graphs-in-python-theory-and-implementation/lessons/dijkstras-algorithm/