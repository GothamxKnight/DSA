class Solution {
    public long countGood(int[] nums, int k) {
        int l=0,r=0;
        int n=nums.length;
        long cnt=0l;
        HashMap<Integer,Integer> map=new HashMap<>();
        long curr=0l;
        while(r<n){
            if(map.containsKey(nums[r])){
                curr+=map.get(nums[r]);
            }
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(curr>=k){
                curr-=map.get(nums[l])-1;
                cnt+=n-r;
                if(map.get(nums[l])==1)map.remove(nums[l]);
                else map.put(nums[l],map.get(nums[l])-1);
                l++;
            }
            r++;
        }
        return cnt;

    }
}