class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        HashMap<Integer,List<int[]>> adj=new HashMap<>();
        for(int i=0;i<n;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int arr[]:edges){
            adj.get(arr[0]).add(new int[]{arr[1],arr[2]});
            adj.get(arr[1]).add(new int[]{arr[0],arr[2]});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });
        int []dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        pq.add(new int[]{0,0});
        while(!pq.isEmpty()){
            int[] node=pq.poll();
            List<int[]> neighbour=adj.get(node[0]);
            int curr_dist=node[1];
            if(curr_dist>dist[node[0]])continue;
            for(int temp[]:neighbour){
                if(curr_dist+temp[1]<dist[temp[0]] && curr_dist+temp[1]<disappear[temp[0]]){
                    pq.add(new int[]{temp[0],curr_dist+temp[1]});
                    dist[temp[0]]=curr_dist+temp[1];
                }
            }
        }
        for(int i=0;i<n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                dist[i]=-1;
            }
        }
        return dist;
    }
}