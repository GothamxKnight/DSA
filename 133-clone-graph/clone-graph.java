/*
// Definition for a Node.
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
        if(node ==null)return null;
        HashMap<Node ,Node> map=new HashMap<>();
        Queue<Node>q=new ArrayDeque<>();
        map.put(node,new Node(node.val));
        q.add(node);
        while(!q.isEmpty()){
            Node curr=q.poll();
            for(Node branch:curr.neighbors){
                if(!map.containsKey(branch)){
                    map.put(branch,new Node(branch.val));
                    q.add(branch);
                }
                map.get(curr).neighbors.add(map.get(branch));
            }
        }
        return map.get(node);
    }
}