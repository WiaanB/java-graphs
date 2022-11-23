import java.util.ArrayList;

class GraphTraverser {
    
    public static void depthFirstTraversal(Vertex start, ArrayList<Vertex> visitedVertices) {
        System.out.println(start.getData());
        for (Edge e: start.getEdges()) {
            Vertex neighbour = e.getEnd();

            if (!visitedVertices.contains(neighbour)) {
                visitedVertices.add(neighbour);
                GraphTraverser.depthFirstTraversal(neighbour, visitedVertices);
            }
        }
    }

    public static void breadthFirstSearch(Vertex start, ArrayList<Vertex> visitedVertices) {
        Queue visitedQueue = new Queue();
        visitedQueue.enqueue(start);
        while (!visitedQueue.isEmpty()) {
            Vertex current = visitedQueue.dequeue();
            System.out.println(current.getData());

            for (Edge e: current.getEdges()) {
                Vertex neighbour = e.getEnd();
                if (!visitedVertices.contains(neighbour)) {
                    visitedVertices.add(neighbour);
                    visitedQueue.enqueue(neighbour);
                }
            }
        }
    }

    public static void main(String[] args) {
        TestGraph test = new TestGraph();
        Vertex startingVertex = test.getStartingVertex();

        ArrayList<Vertex> visitedVerticesDFS = new ArrayList<Vertex>();
        visitedVerticesDFS.add(startingVertex);
        System.out.println("Depth First Search:");
        GraphTraverser.depthFirstTraversal(startingVertex, visitedVerticesDFS);

        ArrayList<Vertex> visitedVerticesBFS = new ArrayList<Vertex>();
        visitedVerticesBFS.add(startingVertex);
        System.out.println("Breadth First Search:");
        GraphTraverser.breadthFirstSearch(startingVertex, visitedVerticesBFS);
    }
}
