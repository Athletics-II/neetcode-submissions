/*
Definition for a Node.
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
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node==null) return null;

        Map<Node, Node> copy = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        copy.put(node, new Node(node.val));

        while (!q.isEmpty()) {
            Node curr = q.poll();
            for (Node n : curr.neighbors) {
                if (!copy.containsKey(n)) {
                    copy.put(n, new Node(n.val));
                    q.add(n);
                }
                copy.get(curr).neighbors.add(copy.get(n));
            }
        }
        return copy.get(node);
    }
}