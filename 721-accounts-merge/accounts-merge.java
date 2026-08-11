class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,Integer> map=new HashMap<>();
        Map<Integer,String> map2=new HashMap<>();
        Map<String,String> map3=new HashMap<>();
        int j=1;
        for(List<String> temp:accounts){
            for(int i=1;i<temp.size();i++){
                if(!map.containsKey(temp.get(i))){
                    map.put(temp.get(i),j);
                    map2.put(j++,temp.get(i));
                    map3.put(temp.get(i),temp.get(0));
                }
            }
        }
        Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int i=1;i<j;i++)adj.put(i,new ArrayList<>());
        for(List<String> temp:accounts){
            int key=map.get(temp.get(1));
            for(int i=2;i<temp.size();i++){
                int val=map.get(temp.get(i));
                adj.get(key).add(val);
                adj.get(val).add(key);
            }
        }
        List<List<String>> res=new ArrayList<>();
        boolean visited[]=new boolean [j];
        for(int i=1;i<j;i++){
            if(!visited[i]){
                visited[i]=true;
                List<String> path=new ArrayList<>();
                path.add(map2.get(i));
                dfs(i,visited,adj,map2,path);
                List<String> user=new ArrayList<>();
                user.add(map3.get(map2.get(i)));
                Collections.sort(path);
                for(String email:path)user.add(email);
                res.add(new ArrayList<>(user));
            }
        }
        return res;
    }
    static void dfs(int i,boolean []visited,Map<Integer,List<Integer>> adj,Map<Integer,String> map2,List<String> pt){
        List<Integer> path=adj.get(i);
        for(Integer a:path){
            if(!visited[a]){
                pt.add(map2.get(a));
                visited[a]=true;
                dfs(a,visited,adj,map2,pt);
            }
        }
    }
}