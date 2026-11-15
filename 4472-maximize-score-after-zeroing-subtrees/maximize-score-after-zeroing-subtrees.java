class Solution {
    public int maxScore(int[] parent, int[] op, int[] score) {
        HashMap<Integer,List<Integer>> adj=new HashMap<>();
        int n=parent.length;
        for(int i=0;i<n;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int i=1;i<n;i++){
            adj.get(parent[i]).add(i);
        }
        return bfs(adj,0,op,score);
    }
    static int bfs(HashMap<Integer,List<Integer>> adj,int node,int[]op,int []score){

        int min=Integer.MAX_VALUE;
        int total_sum=score[node];
        for(int child:adj.get(node)){
            int total=bfs(adj,child,op,score);
            total_sum+=total;
            min=Math.min(min,total);
        }
        if(min==Integer.MAX_VALUE){
            return total_sum;
        }
        if(op[node]==1){
            total_sum-=min;
        }else{
            if(min<0){
                total_sum-=min;
            }
        }
        return total_sum;
    }
}