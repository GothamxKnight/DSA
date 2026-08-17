class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int topo[]=new int[n];
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++)map.put(i,new ArrayList<>());
        for(int i=0;i<n;i++){
            int arr[]=graph[i];
            topo[i]=arr.length;
            for(int a:arr){
                map.get(a).add(i);
            }
        }
        Queue<Integer> q=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(topo[i]==0 ){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int v=q.poll();
                List<Integer> list=map.get(v);
                for(int a:list){
                    topo[a]--;
                    if(topo[a]==0){
                        q.add(a);
                    }
                }
            }
        }
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(topo[i]==0){
                res.add(i);
            }
        }
        Collections.sort(res);
        return res;
    }
}