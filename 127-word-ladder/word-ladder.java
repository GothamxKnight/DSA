class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        HashMap<String,Integer> map2=new HashMap<>();
        map2.put(beginWord,1);
        int val=2;
        for(String str:wordList){
            map2.put(str,val++);
        }
        if(!map2.containsKey(endWord))return 0;
        for(String str:wordList){
            map.put(map2.get(str),new ArrayList<>());
        }
        map.put(map2.get(beginWord),new ArrayList<>());
        for(String str:wordList){
            int cnt=0;
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)!=beginWord.charAt(i))cnt++;
            }
            int first=map2.get(beginWord);
            int sec=map2.get(str);
            if(cnt==1){
                map.get(first).add(sec);
                map.get(sec).add(first);
            }
        }
        for(int i=0;i<wordList.size();i++){
            String str=wordList.get(i);
            for(int j=i+1;j<wordList.size();j++){
                String str2=wordList.get(j);
                int cnt=0;
                for(int k=0;k<str.length();k++){
                    if(str.charAt(k)!=str2.charAt(k))cnt++;
                }
                int first=map2.get(str2);
                int sec=map2.get(str);
                if(cnt==1){
                    map.get(first).add(sec);
                    map.get(sec).add(first);
                }
            }
        }
        Queue<Integer> q=new ArrayDeque<>();
        q.add(map2.get(beginWord));
        int step=1;
        boolean visited[]=new boolean[wordList.size()+2];
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                int vertex=q.poll();
                if(vertex==map2.get(endWord))return step;
                if(!visited[vertex]){
                    visited[vertex]=true;
                    List<Integer> temp=map.get(vertex);
                    for(int a:temp){
                        q.add(a);
                    }
                }
            }
            step++;
        }
        return 0;
    }
}