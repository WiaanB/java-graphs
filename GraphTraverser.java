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

    public static void main(String[] args) {
        TestGraph test = new TestGraph();
        Vertex startingVertex = test.getStartingVertex();
        ArrayList<Vertex> visitedVertices = new ArrayList<Vertex>();
        visitedVertices.add(startingVertex);

        GraphTraverser.depthFirstTraversal(startingVertex, visitedVertices);
    }
}
