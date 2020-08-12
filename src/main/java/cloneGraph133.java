package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class cloneGraph133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private HashMap<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        Node newNode = new Node(node.val, new ArrayList<>());
        visited.put(node, newNode);
        for (Node n : node.neighbors) {
            newNode.neighbors.add(cloneGraph(n));
        }
        return newNode;
    }
}
