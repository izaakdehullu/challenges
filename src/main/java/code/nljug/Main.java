package main.java.code.nljug;

import java.util.List;

public class Main {


    public static void main(String[] args) {

        String workingDirectory = System.getProperty("user.dir");
        String fileName = workingDirectory+"/src/main/resources/file2.txt";

        UnidirectedGraph graph = GraphBuilder.createGraph(fileName);

        List<Edge> minimumSpanningTree = graph.minimumSpanningTree();
        System.out.println("Minimum Spanning Tree Edges:");

        int totalWeight = 0;
        for (Edge edge : minimumSpanningTree) {
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
            totalWeight += edge.weight;
        }
        System.out.println("total Weight:" + totalWeight );
    }

}