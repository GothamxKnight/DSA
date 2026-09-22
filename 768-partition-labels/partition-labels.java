class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res=new ArrayList<>();
        HashMap<Character,int[]> map=new HashMap<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch,new int[]{i,i});
            }
            map.get(ch)[1]=i;
        }
        int st=0;
        while(st<n){
            char ch=s.charAt(st);
            int upperbound=map.get(ch)[1];
            for(int i=st;i<=Math.min(upperbound,n-1);i++){
                upperbound=Math.max(upperbound,map.get(s.charAt(i))[1]);
            }
            res.add(upperbound-st+1);
            st=upperbound+1;
        }
        return res;
    }
}