class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        HashMap<Integer,ArrayList<Integer>> adj=new HashMap<>();
        for(int []arr:invocations){
            adj.putIfAbsent(arr[0],new ArrayList<>());
            adj.get(arr[0]).add(arr[1]);
        }
        Integer arr[]=new Integer[n];
        for(int i=0;i<n;i++)arr[i]=i;
        List<Integer>sus=suspicious(adj,k,n);
        HashMap<Integer,Integer>map=new HashMap<>();
        for(Integer a:sus){
            map.put(a,1);
        }
        for(int i=0;i<n;i++){
            if(!map.containsKey(i)){
                if(adj.containsKey(i)){
                    List<Integer> temp=adj.get(i);
                    for(Integer a:temp){
                        if(map.containsKey(a))return new ArrayList<>(Arrays.asList(arr));
                    }
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!map.containsKey(i))ans.add(i);
        }
        return ans;
    }
    static List<Integer> suspicious(HashMap<Integer,ArrayList<Integer>> adj,int k,int n){
        boolean []visited=new boolean [n];
        Queue<List<Integer>> q=new ArrayDeque<>();
        List<Integer> res=new ArrayList<>();
        res.add(k);
        visited[k]=true;
        if(adj.containsKey(k))q.add(adj.get(k));
        while(!q.isEmpty()){
            List<Integer> temp=q.poll();
            for(int node:temp){
                if(!visited[node]){
                    res.add(node);
                    visited[node]=true;
                    if(adj.containsKey(node)){
                        q.add(adj.get(node));
                    }
                }
            }
        }
        return res;
    }
}