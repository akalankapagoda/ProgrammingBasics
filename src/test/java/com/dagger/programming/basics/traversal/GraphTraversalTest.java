package com.dagger.programming.basics.traversal;

import com.dagger.programming.basics.model.AdjacencyListGraphImpl;
import com.dagger.programming.basics.model.AdjacencyMatrixGraphImpl;
import com.dagger.programming.basics.model.Graph;

/**
 * Warning! This is a test class which is not a test class.
 */
public class GraphTraversalTest {

    public GraphTraversalTest() {

    }

    private static Graph adjacencyListGraph;
    private static Graph adjacencyMatrixGraph;

    public static void main(String[] args) {
        initializeGraphs();

        runAdjacencyListGraphBreadthFirstTraversal();
        runAdjacencyMatrixGraphBreadthFirstTraversal();

        runAdjacencyListGraphDepthFirstTraversal();
        runAdjacencyMatrixGraphDepthFirstTraversal();

    }

    public static void initializeGraphs() {
        adjacencyListGraph = new AdjacencyListGraphImpl(5);
        adjacencyMatrixGraph = new AdjacencyMatrixGraphImpl(5);

        adjacencyListGraph.addEdge(2, 1);
        adjacencyListGraph.addEdge(3, 2);
        adjacencyListGraph.addEdge(1, 3);
        adjacencyListGraph.addEdge(3, 4);
        adjacencyListGraph.addEdge(1, 4);
        adjacencyListGraph.addEdge(1, 0);
        adjacencyListGraph.addEdge(0, 4);

        adjacencyMatrixGraph.addEdge(2, 1);
        adjacencyMatrixGraph.addEdge(3, 2);
        adjacencyMatrixGraph.addEdge(1, 3);
        adjacencyMatrixGraph.addEdge(3, 4);
        adjacencyMatrixGraph.addEdge(1, 4);
        adjacencyMatrixGraph.addEdge(1, 0);
        adjacencyMatrixGraph.addEdge(0, 4);
    }

    public static void runAdjacencyListGraphBreadthFirstTraversal() {
        System.out.println("\nAdjacencyList BreadthFirstTraversal Iterative\n");
        adjacencyListGraph.breadthFirstTraversalIterate(0);

        System.out.println("\nAdjacencyList BreadthFirstTraversal Recursive\n");
        adjacencyListGraph.breadthFirstTraversalRecursive(0);
    }

    public static void runAdjacencyListGraphDepthFirstTraversal() {
        System.out.println("\nAdjacencyList DepthFirstTraversal Iterative\n");
        adjacencyListGraph.depthFirstTraversalIterate(0);

        System.out.println("\nAdjacencyList DepthFirstTraversal Recursive\n");
        adjacencyListGraph.depthFirstTraversalRecursive(0);
    }

    public static void runAdjacencyMatrixGraphBreadthFirstTraversal() {
        System.out.println("\nAdjacencyMatrix BreadthFirstTraversal Iterative\n");
        adjacencyMatrixGraph.breadthFirstTraversalIterate(0);

        System.out.println("\nAdjacencyMatrix BreadthFirstTraversal Recursive\n");
        adjacencyMatrixGraph.breadthFirstTraversalRecursive(0);
    }

    public static void runAdjacencyMatrixGraphDepthFirstTraversal() {
        System.out.println("\nAdjacencyMatrix DepthFirstTraversal Iterative\n");
        adjacencyMatrixGraph.depthFirstTraversalIterate(0);

        System.out.println("\nAdjacencyMatrix DepthFirstTraversal Recursive\n");
        adjacencyMatrixGraph.depthFirstTraversalRecursive(0);
    }
}
