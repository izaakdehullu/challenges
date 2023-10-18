package main.java.code.nljug;

class Edge implements Comparable<Edge> {
    String src;
    String dest;
    int weight;

    public Edge(String src, String dest, int... weight) {
        this.src = src;
        this.dest = dest;
        if (weight.length!=0) {
            this.weight = weight[0];
        }
    }

        public int compareTo(Edge other) {
            return Double.compare(this.weight, other.weight);
    }


public String src() {
    return src;
}

public String dest() {
    return dest;
}
public int weight() {
    return weight;
}
}