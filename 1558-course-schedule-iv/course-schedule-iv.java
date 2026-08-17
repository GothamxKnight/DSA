class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int []indegree=new int[numCourses];
        HashMap<Integer,List<Integer>> adj=new HashMap<>();
        for(int i=0;i<numCourses;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int arr[]:prerequisites){
            indegree[arr[1]]++;
            adj.get(arr[0]).add(arr[1]);
        }
        Queue<Integer> q=new ArrayDeque<>();
        HashMap<Integer,Set<Integer>> map=new HashMap<>();
        for(int i=0;i<numCourses;i++){
            map.put(i,new HashSet<>());
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                int vertex=q.poll();
                List<Integer> neigh=adj.get(vertex);
                for(int a:neigh){
                    indegree[a]--;
                    map.get(a).add(vertex);
                    map.get(a).addAll(map.get(vertex));
                    if(indegree[a]==0){
                        q.add(a);
                    }
                }
            }
        }
        List<Boolean> res=new ArrayList<>();
        for(int arr[]:queries){
            if(map.get(arr[1]).contains(arr[0])){
                res.add(true);
            }else{
                res.add(false);
            }
        }
        return res;
    }
}