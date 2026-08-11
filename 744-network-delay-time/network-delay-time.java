class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer,ArrayList<int[]>> adj=new HashMap<>();
        for(int i=1;i<=n;i++)adj.put(i,new ArrayList<>());
        for(int arr[]:times){
            int ui=arr[0];
            int vi=arr[1];
            int wi=arr[2];
            adj.get(ui).add(new int[]{vi,wi});
        }
        boolean visited[]=new boolean[n+1];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });
        int time=0;
        pq.add(new int[]{k,0});
        while(!pq.isEmpty()){
            if(!visited[pq.peek()[0]]){
                int []node=pq.peek();
                visited[node[0]]=true;
                List<int[]> temp=adj.get(pq.poll()[0]);
                for(int arr[]:temp){
                    pq.add(new int[]{arr[0],node[1]+arr[1]});
                }
                time=Math.max(time,node[1]);
            }else{
                pq.poll();
            }
        }
        for(int i=1;i<n+1;i++){
            if(!visited[i])return -1;
        }
        return time;
    }
}