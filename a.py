import sys

class PriorityQueueArrayUnordered:
    def __init__(self, capacity) :
        self.maxSize = capacity
        self.pqArray = {}
        self.length = 0
    def enqueue(self, value, index) :
        if (self.length == self.maxSize) :
            return      
        self.pqArray[self.length] = [value,index]
        self.length += 1
    def dequeue(self) : 
        if (self.length == 0 ) :
            return 
        minIndex = 0
        for  i in range(1, self.length):  
            if (self.pqArray[i][0] < self.pqArray[minIndex][0]) : 
                minIndex = i; 
        item = self.pqArray[minIndex]; 
        self.length -= 1 
        self.pqArray[minIndex] = self.pqArray[self.length]; #move the last to this spot
        return item
    def peek(self) : 
        if (self.length == 0) :
            print("queue is empty")
            return False
        minIndex = 0
        for  i in range(1, self.length):  
            if (self.pqArray[i][0] < self.pqArray[minIndex][0]) : 
                minIndex = i; 
        return self.pqArray[minIndex]

class Graph:
    def __init__(self, num_of_vertices):
        self.v = num_of_vertices
        self.edges = [[-1 for i in range(num_of_vertices)] for j in range(num_of_vertices)]
        self.visited = []
    def add_edge(self, u, v, weight):
        self.edges[u][v] = weight
        self.edges[v][u] = weight
        
def dijkstra(graph, start_vertex):
    D = {v:float('inf') for v in range(graph.v)}
    D[start_vertex] = 0
    
    pq = PriorityQueueArrayUnordered(graph.v)
    pq.enqueue(0, start_vertex)

    while pq.peek():
        [dist, current_vertex] = pq.dequeue()
        graph.visited.append(current_vertex)

        for neighbor in range(graph.v):
            if graph.edges[current_vertex][neighbor] != -1:
                distance = graph.edges[current_vertex][neighbor]
                if neighbor not in graph.visited:
                    old_cost = D[neighbor]
                    new_cost = D[current_vertex] + distance
                    if new_cost < old_cost:
                        pq.enqueue(new_cost, neighbor)
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

