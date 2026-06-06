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

        if(node == null) return node;
        
        Set<Node> visited = new HashSet();
        Map<Integer, Node> adj = new HashMap();
        return dfs(node, adj, visited);
        
    }

    public Node dfs(Node node, Map<Integer, Node> adj, Set<Node> visited) {
       
        visited.add(node);
        Node newNode = new Node(node.val, new ArrayList());
        adj.put(node.val, newNode);
        for(Node adjNode: node.neighbors) {
            if(!visited.contains(adjNode)) {
                Node n = dfs(adjNode,adj,visited);
                newNode.neighbors.add(n);

            } else {
                Node nNode = adj.get(adjNode.val);
                newNode.neighbors.add(nNode);

            }
        }

        return newNode;
    }
}