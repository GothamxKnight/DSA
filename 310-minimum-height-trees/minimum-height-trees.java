class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1)return Collections.singletonList(0);
        List<Set<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new HashSet<>());
        for(int edge[]:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        List<Integer>leafnode=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(adj.get(i).size()==1)leafnode.add(i);
        }
        while(n>2){
            n-=leafnode.size();
            List<Integer> newleafnode=new ArrayList<>();
            for(int i:leafnode){
                int j=adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if(adj.get(j).size()==1)newleafnode.add(j);
            }
            leafnode=newleafnode;
        }
        return leafnode;
    }
}