import java.util.*;


/**
 * This class represents a directed graph
 */
public class DGraph {

    /**
     * This class represents a node in the graph
     * Each node has a key and a value
     * Each node also has a list of edges that are adjacent to it
     * Each edge has a sink node and a weight
     */
    private class Node {
        int key;
        int value;
        List<Edge> adjList = new ArrayList<>();

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, Node> nodes = new HashMap<>();

    /**
     * This class represents an edge in the graph
     * Each edge has a sink node and a weight
     */
    private class Edge {
        Node sink;
        double weight;

        Edge(Node V, double w) {
            sink = V;
            weight = w;
        }
    }

    /**
     * This class represents a pair of a cost and a node
     * This is used in the heuristic method
     * The heuristic method returns a pair of the cost and the last node visited
     * This class is a helper class for the heuristic method to allow the function to return two values
     */
    private class Pair {
        double cost;
        Node lastNode;

        Pair(double cost, Node lastNode) {
            this.cost = cost;
            this.lastNode = lastNode;
        }
    }

    /**
     * This method adds a node to the graph
     *
     * @param key   Key of the node
     * @param value Value of the node
     */
    public void addNode(int key, int value) {
        nodes.put(key, new Node(key, value));
    }

    /**
     * This method adds an edge to the graph
     * It also adds the nodes if they are not already in the graph
     *
     * @param k1 Key of the first node
     * @param k2 Key of the second node
     * @param w  Weight of the edge
     */
    public void addEdge(int k1, int k2, double w) {
        if (!nodes.containsKey(k1)) {
            addNode(k1, k1);
        }
        if (!nodes.containsKey(k2)) {
            addNode(k2, k2);
        }
        nodes.get(k1).adjList.add(new Edge(nodes.get(k2), w));
    }

    /**
     * This method returns string representation of the graph
     *
     * @return string representation of the graph
     */
    public String toString() {
        String str = "";
        for (int key : nodes.keySet()) {
            str += key + ": [";
            Node u = nodes.get(key);

            for (Edge adj : u.adjList) {
                str += adj.sink.key + "(" + adj.weight + "), ";
            }
            str += "]\n";
        }
        return str;
    }

    /**
     * This method implements the heuristic method
     *
     * @param startKey Key of the starting node
     * @return cost of the path
     */
    public double heuristic(int startKey) {
        LinkedList<Integer> path = new LinkedList<>();
        path.add(startKey);
        Node startNode = nodes.get(startKey);
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(startNode);

        double cost = 0;
        Node lastNode = null;

        while (!queue.isEmpty()) {
            Node current = queue.pollFirst();
            double minEdgeWeight = Double.MAX_VALUE;
            Node minEdgeNode = null;
            for (Edge e : current.adjList) {
                if (!path.contains(e.sink.key)) {
                    if (e.weight < minEdgeWeight) {
                        minEdgeWeight = e.weight;
                        minEdgeNode = e.sink;
                    }
                }
            }
            if (minEdgeNode != null) {
                queue.add(minEdgeNode);
                path.add(minEdgeNode.key);
                cost += minEdgeWeight;
                lastNode = minEdgeNode;
            }
        }
        for (Edge e : lastNode.adjList) {
            if (e.sink.key == startKey) {
                cost += e.weight;
                break;
            }
        }
        // Round to 1 decimal place
        cost = Math.round(cost * 10) / 10.0;
        System.out.println("cost = " + cost + ", visitOrder = " + path);
        return cost;
    }

    /**
     * This method implements the backtracking method
     *
     * @param startKey Key of the starting node
     * @return cost of the path
     */
    public double backtracking(int startKey) {
        LinkedList<Integer> path = new LinkedList<>();
        path.add(startKey);
        Node startNode = nodes.get(startKey);
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(startNode);
        double cost = 0;
        Node lastNode = null;
        Pair result = backtrackingHelper(queue, path, cost, lastNode);
        cost = result.cost;
        lastNode = result.lastNode;
        for (Edge e : lastNode.adjList) {
            if (e.sink.key == startKey) {
                cost += e.weight;
                break;
            }
        }
        cost = Math.round(cost * 10) / 10.0;
        System.out.println("cost = " + cost + ", visitOrder = " + path);
        return cost;
    }

    /**
     * This is a helper method for the backtracking method
     *
     * @param queue    Queue of nodes
     * @param path     Path of nodes
     * @param cost     Cost of the path
     * @param lastNode Last node visited
     * @return Pair of cost and last node visited
     */
    private Pair backtrackingHelper(LinkedList<Node> queue, LinkedList<Integer> path, double cost, Node lastNode) {
        Node current = queue.pollFirst();
        double minEdgeWeight = Double.MAX_VALUE;
        Node minEdgeNode = null;
        for (Edge e : current.adjList) {
            if (!path.contains(e.sink.key)) {
                if (e.weight < minEdgeWeight) {
                    minEdgeWeight = e.weight;
                    minEdgeNode = e.sink;
                }
            }
        }
        if (minEdgeNode != null) {
            queue.add(minEdgeNode);
            path.add(minEdgeNode.key);
            cost += minEdgeWeight;
            lastNode = minEdgeNode;
            Pair result = backtrackingHelper(queue, path, cost, lastNode);
            cost = result.cost;
            lastNode = result.lastNode;
        }
        return new Pair(cost, lastNode);
    }

    /**
     * This method is my own method
     * It loops through all the edges and finds the minimum edge
     * It then adds the node of the minimum edge to the path
     * It repeats this process until all nodes are visited
     *
     * @param startKey Key of the starting node
     * @return cost of the path
     */
    public double own_method(int startKey) {
        LinkedList<Integer> path = new LinkedList<>();
        Set<Integer> toVisit = nodes.keySet();
        path.add(startKey);
        Node startNode = nodes.get(startKey);
        double count = 0;

        Node minEdgeNode = null;
        double minEdgeWeight = Double.MAX_VALUE;
        for (int i = 0; i < toVisit.size(); i++) {
            for (Edge e : startNode.adjList) {
                if (!path.contains(e.sink.key)) {
                    if (e.weight < minEdgeWeight) {
                        minEdgeWeight = e.weight;
                        minEdgeNode = e.sink;
                    }
                }
            }
            if (minEdgeNode != null) {
                path.add(minEdgeNode.key);
                count += minEdgeWeight;
                startNode = minEdgeNode;
                minEdgeNode = null;
                minEdgeWeight = Double.MAX_VALUE;
            }
        }
        for (Edge e : startNode.adjList) {
            if (e.sink.key == startKey) {
                count += e.weight;
                break;
            }
        }
        count = Math.round(count * 10) / 10.0;
        System.out.println("cost = " + count + ", visitOrder = " + path);
        return count;
    }

    public void timing(int startKey) {
        long startTime = System.nanoTime();
        double cost = heuristic(startKey);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        System.out.println("heuristic: cost=" + cost + ", " + duration + " milliseconds");

        startTime = System.nanoTime();
        cost = backtracking(startKey);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;
        System.out.println("backtracking: cost=" + cost + ", " + duration + " milliseconds");

        startTime = System.nanoTime();
        double count = own_method(startKey);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;
        System.out.println("own_method: cost=" + count + ", " + duration + " milliseconds");
    }
}
