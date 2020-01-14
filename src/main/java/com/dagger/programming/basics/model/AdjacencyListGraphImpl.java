package com.dagger.programming.basics.model;

import java.util.*;

public class AdjacencyListGraphImpl implements Graph {

    private List<Integer>[] graph;

    public AdjacencyListGraphImpl(int initialVertexCount) {
        graph = new ArrayList[initialVertexCount];

        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    @Override
    public void addEdge(int v1, int v2) {
        graph[v1].add(v2);
        graph[v2].add(v1);
    }

    @Override
    public void breadthFirstTraversalIterate(int start) {
        Set<Integer> traversed = new HashSet<>();

        Queue<Integer> toTraverse = new LinkedList<>();

        toTraverse.add(0);

        while(!toTraverse.isEmpty()) {
            int vertex = toTraverse.poll();

            if (traversed.contains(vertex)) {
                continue;
            }

            System.out.print("->" + vertex);
            traversed.add(vertex);

            for (int adjacentVertex : graph[vertex]) {
                toTraverse.add(adjacentVertex);
            }
        }
    }

    @Override
    public void breadthFirstTraversalRecursive(int start) {
        boolean[] visited = new boolean[graph.length];
        visited[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        breadthFirstTraversalRecursive(visited, queue);
    }

    private void breadthFirstTraversalRecursive(boolean[] visited, Queue<Integer> queue) {

        if (queue.isEmpty()) {
            return;
        }

        int vertex = queue.poll();
        System.out.print("->" + vertex);

        for (int adjacentVertex : graph[vertex]) {
            if (!visited[adjacentVertex]) {
                queue.add(adjacentVertex);
                visited[adjacentVertex] = true;
            }
        }

        breadthFirstTraversalRecursive(visited, queue);
    }

    @Override
    public void depthFirstTraversalIterate(int start) {
        boolean[] added = new boolean[graph.length];

        Stack<Integer> toTraverse = new Stack<>();

        toTraverse.push(start);
        added[start] = true;

        while(!toTraverse.isEmpty()) {
            int vertex = toTraverse.pop();

            System.out.print("->" + vertex);

            for (int adjacentVertex : graph[vertex]) {

                if (!added[adjacentVertex]) {
                    toTraverse.push(adjacentVertex);
                    added[adjacentVertex] = true;
                }
            }

        }
    }

    @Override
    public void depthFirstTraversalRecursive(int start) {
        boolean[] visited = new boolean[graph.length];
        visited[start] = true;
        depthFirstTraversalRecursive(start, visited);
    }

    public void depthFirstTraversalRecursive(int vertex, boolean[] visited) {

        System.out.print("->" + vertex);
        visited[vertex] = true;

        for (int adjacentVertex : graph[vertex]) {
            if (!visited[adjacentVertex]) {
                depthFirstTraversalRecursive(adjacentVertex, visited);
            }
        }
    }
}
