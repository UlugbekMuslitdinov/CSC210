import java.util.*;

public class DGraph {
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

    private class Edge {
        Node sink;
        double weight;

        Edge(Node V, double w) {
            sink = V;
            weight = w;
        }
    }

    private class Pair {
        double cost;
        Node lastNode;

        Pair(double cost, Node lastNode) {
            this.cost = cost;
            this.lastNode = lastNode;
        }
    }

    public void addNode(int key, int value) {
        nodes.put(key, new Node(key, value));
    }

    public void addEdge(int k1, int k2, double w) {
//        Node u = nodes.get(k1);
//        Node v = nodes.get(k2);
//        u.adjList.add(new Edge(v, w));
        if (!nodes.containsKey(k1)) {
            addNode(k1, k1);
        }
        if (!nodes.containsKey(k2)) {
            addNode(k2, k2);
        }
        nodes.get(k1).adjList.add(new Edge(nodes.get(k2), w));
    }

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
        for (Edge e: lastNode.adjList) {
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
        for (Edge e: lastNode.adjList) {
            if (e.sink.key == startKey) {
                cost += e.weight;
                break;
            }
        }
        cost = Math.round(cost * 10) / 10.0;
        System.out.println("cost = " + cost + ", visitOrder = " + path);
        return cost;
    }

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
}
