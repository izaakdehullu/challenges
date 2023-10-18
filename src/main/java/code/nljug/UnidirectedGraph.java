package main.java.code.nljug;

import java.util.*;

class UnidirectedGraph {
    private Set<String> vertices;
    private List<Edge> edges;

    public UnidirectedGraph() {
        vertices = new HashSet<>();
        edges = new ArrayList<>();
    }

    public void addEdge(String src, String dest, int weight) {
        if (alreadyExists(src,dest)) {
            return;
        }
        vertices.add(src);
        vertices.add(dest);
        Edge edge = new Edge(src, dest, weight);
        edges.add(edge);
    }

    private boolean alreadyExists(String src, String dest) {
        for (Edge edge : edges) {
            if (edge.src().equals(dest) && edge.dest().equals(src)) {
                return true;
            }
        }        
        return false;
    }


    public List<Edge> minimumSpanningTree() {
        List<Edge> minimumSpanningTree = new ArrayList<>();
        Collections.sort(edges);

        Map<String, String> parent = new HashMap<>();
        for (String vertex : vertices) {
            parent.put(vertex, vertex);
        }

        int edgesAdded = 0;
        int index = 0;

        while (edgesAdded < vertices.size() - 1) {
            Edge currentEdge = edges.get(index);
            String srcParent = find(parent, currentEdge.src);
            String destParent = find(parent, currentEdge.dest);

            if (!srcParent.equals(destParent)) {
                minimumSpanningTree.add(currentEdge);
                union(parent, srcParent, destParent);
                edgesAdded++;
            }

            index++;
        }

        return minimumSpanningTree;
    }

    private String find(Map<String, String> parent, String node) {
        if (parent.get(node).equals(node)) {
            return node;
        }
        return find(parent, parent.get(node));
    }

    private void union(Map<String, String> parent, String x, String y) {
        String xParent = find(parent, x);
        String yParent = find(parent, y);
        parent.put(yParent, xParent);
    }
}



