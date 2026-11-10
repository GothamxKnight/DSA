class Solution {
    static long mod=1000000007;
    public int numberOfWays(int startPos, int endPos, int k) {
        return (int)dp(startPos,endPos,k,new HashMap<>());
    }
    static long dp(int curr_pos,int endPos,int k,HashMap<List<Integer>,Long> map){
        if(k<Math.abs(endPos-curr_pos))return 0l;
        if(k==0){
            return curr_pos==endPos?1l:0l;
        }
        List<Integer> key=new ArrayList<>();
        key.add(curr_pos);
        key.add(k);
        if(map.containsKey(key)){
            return map.get(key);
        }
        long left=dp(curr_pos-1,endPos,k-1,map)%mod;
        long right=dp(curr_pos+1,endPos,k-1,map)%mod;
        long ans=(left+right)%mod;
        map.put(key,ans);
        return ans;
    }
}