package com.dagger.programming.basics.model;

public interface Graph {

    void addEdge(int v1, int v2);

    void breadthFirstTraversalIterate(int start);

    void breadthFirstTraversalRecursive(int start);

    void depthFirstTraversalIterate(int start);

    void depthFirstTraversalRecursive(int start);
}
