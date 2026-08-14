class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        if(n==1)return new int[]{0};
        List<Integer>[]adj=new ArrayList [n];
        int topo[]=new int[n];
        for(int i=0;i<n;i++)adj[i]=(new ArrayList<>());
        for(int []arr:prerequisites){
            int src=arr[1];
            int dst=arr[0];
            adj[src].add(dst);
            topo[dst]++;
        }
        Queue<Integer> q=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(topo[i]==0){
                q.add(i);
            }
        }
        int index=0;
        int res[]=new int[n];
        while(!q.isEmpty()){
            int curr=q.poll();
            res[index++]=curr;
            for(int a:adj[curr]){
                topo[a]--;
                if(topo[a]==0)q.add(a);
            }
        }
        if(index==n)return res;
        return new int[]{};
    }
}