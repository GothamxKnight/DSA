class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int topo[]=new int[n+1];
        for(int arr[]:edges){
            topo[arr[0]]++;
            topo[arr[1]]++;
        }
        Queue<Integer>q=new ArrayDeque<>();
        for(int i=1;i<n+1;i++){
            if(topo[i]==1)q.add(i);
        }
        boolean visited[]=new boolean[n+1];
        while(!q.isEmpty()){
            int len=q.size();
            for(int i=0;i<len;i++){
                int v=q.poll();
                topo[v]--;
                if(!visited[v]){
                    visited[v]=true;
                    for(int arr[]:edges){
                        if(!visited[arr[1]] && arr[0]==v){
                            topo[arr[1]]--;
                        }else if(!visited[arr[0]] && arr[1]==v){
                            topo[arr[0]]--;
                        }
                        if(topo[arr[0]]==1){
                            q.add(arr[0]);
                        }
                        if(topo[arr[1]]==1){
                            q.add(arr[1]);
                        }
                    }
                }
            }
        }
        Set<Integer> list=new HashSet<>();
        for(int i=1;i<=n;i++){
            if(topo[i]>0){
                list.add(i);
            }
        }
        for(int i=n-1;i>=0;i--){
            int arr[]=edges[i];
            if(list.contains(arr[0]) && list.contains(arr[1])){
                return arr;
            }
        }
        return new int[]{};
    }
}