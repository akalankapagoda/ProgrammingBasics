package com.dagger.programming.basics.model;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AdjacencyMatrixGraphImpl implements Graph {

    int[][] graph;

    public AdjacencyMatrixGraphImpl(int initialVertexCount) {
        graph = new int[initialVertexCount][initialVertexCount];
    }

    @Override
    public void addEdge(int v1, int v2) {
        graph[v1][v2] = 1;
        graph[v2][v1] = 1;
    }

    @Override
    public void breadthFirstTraversalIterate(int start) {
        boolean[] visited = new boolean[graph[0].length];
        visited[start] = true;

        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            System.out.print("->" + vertex);
            int[] adjacentVertexes = graph[vertex];

            for (int i = 0; i < adjacentVertexes.length; i++) {
                int adjacentVertexValue = adjacentVertexes[i];
                if (adjacentVertexValue == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    @Override
    public void breadthFirstTraversalRecursive(int start) {
        boolean[] visited = new boolean[graph[0].length];
        visited[start] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        breadthFirstTraversalRecursive(visited, queue);
    }

    public void breadthFirstTraversalRecursive(boolean[] visited, Queue<Integer> queue) {

        if (queue.isEmpty()) {
            return;
        }

        int vertex = queue.poll();
        System.out.print("->" + vertex);

        int[] adjacentVertexes = graph[vertex];

        for (int i = 0; i < adjacentVertexes.length; i++) {
            int adjacentVertexValue = adjacentVertexes[i];

            if (adjacentVertexValue == 1 && !visited[i]) {
                queue.add(i);
                visited[i] = true;
            }
        }

        breadthFirstTraversalRecursive(visited, queue);

    }

    @Override
    public void depthFirstTraversalIterate(int start) {
        boolean[] visited = new boolean[graph[0].length];

        Stack<Integer> stack = new Stack<>();

        stack.push(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            System.out.print("->" + vertex);
            int[] adjacentVertexes = graph[vertex];

            for (int i = 0; i < adjacentVertexes.length; i++) {
                int adjacentVertexValue = adjacentVertexes[i];

                if (adjacentVertexValue == 1 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
    }

    @Override
    public void depthFirstTraversalRecursive(int start) {
        boolean[] visited = new boolean[graph[0].length];

        depthFirstTraversalRecursive(visited, start);
    }

    public void depthFirstTraversalRecursive(boolean[] visited, int vertex) {
        System.out.print("->" + vertex);
        visited[vertex] = true;

        int[] adjacentVertexes = graph[vertex];

        for (int i = 0; i < adjacentVertexes.length; i++) {
            int adjacentVertexValue = adjacentVertexes[i];

            if (adjacentVertexValue == 1 && !visited[i]) {
                depthFirstTraversalRecursive(visited, i);
            }
        }
    }
}
