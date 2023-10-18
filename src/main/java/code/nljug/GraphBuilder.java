package main.java.code.nljug;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileReader;

public class GraphBuilder {

    private static Pattern pattern1 = Pattern.compile("[S|s]witch\\s([A-Za-z]+)\\s");
    private static Pattern pattern2 = Pattern.compile("\\((\\d+,\\s\\d+)\\)");
    private static Pattern pattern3 = Pattern.compile("to\\s([A-Z\\,\\s]+)");
 

    private GraphBuilder  () {
        // do  nothing
    }
     
    /**
     * <p>
     * Maak een undirected graaf o.b.v. een file
     * 
     * @return
     */
    public static UnidirectedGraph createGraph(String fileName) {

        List<String> lines = readLines(fileName);
        Map<String,Node> nodes = createNodes(lines);
        return convertNodesToEdges(nodes);
    }

    /**
     * <p>
     * Lees alle regels van het bestand in. 
     * 
     * @return
     */
    private static List<String> readLines(String fileName){
 
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lines;
    }


    /**
     * <p>
     * Maak een lijst van nodes. Een node is een knooppunt in de graaf
     * heeft een naam, x en y coordinaat en één of meerdere verbindingen naar
     * andere knooppunten in de graaf. 
     * 
     * @param lines
     * @return
     */
    private static Map<String,Node> createNodes(List<String> lines) {

        Map<String,Node> nodes = new HashMap<>();
        for (String line: lines) {
            String name = "";
            Matcher matcher = pattern1.matcher(line);
            if (matcher.find()) {
                name = matcher.group(1);
            }               
            Matcher matcher2 = pattern2.matcher(line);
            String[] values = new String[]{};
            if (matcher2.find()) {
                String value = matcher2.group(1);
                value = value.replace(" ","");
                values = value.split(",", 0);
            }
            Matcher matcher3 = pattern3.matcher(line);
            String[] connections = new String[] {};
            if (matcher3.find()) {
                String value = matcher3.group(1);
                value = value.replace(" ","");
                connections = value.split(",", 0);
            }
            Node node = new Node(name,Integer.valueOf(values[0]),Integer.valueOf(values[1]),connections);
            nodes.put(node.name(),node);
        }
        return nodes;
     }


    private static UnidirectedGraph convertNodesToEdges(Map<String,Node> nodes) {

        UnidirectedGraph graph = new UnidirectedGraph();
        for (Map.Entry<String, Node> entry : nodes.entrySet()) {
            Node node = entry.getValue();
            for (String connection : node.conn()) {
                Node connectedNode = nodes.get(connection);
                graph.addEdge(entry.getKey(), connectedNode.name(), calculateEuclidianDistance(node.X(),node.Y(),connectedNode.X(),connectedNode.Y()));
            }
        }
        return graph;
    }

    private static int calculateEuclidianDistance(int x, int y, int x2, int y2) {
        return (int)Math.floor(Math.sqrt(Math.pow((x2-x),2)+Math.pow((y2-y),2))*100);
    }

}